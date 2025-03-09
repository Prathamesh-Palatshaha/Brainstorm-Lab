# streamlit run appv.py --server.fileWatcherType none use this line to run code

import streamlit as st
from dotenv import load_dotenv
from PyPDF2 import PdfReader
from langchain_community.vectorstores import FAISS
from langchain_huggingface import HuggingFaceEmbeddings
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain.memory import ConversationBufferMemory
from langchain.chains import ConversationalRetrievalChain
from htmlTemplates import css, bot_template, user_template
# from langchain_community.llms import HuggingFaceHub
from langchain_huggingface import HuggingFaceEndpoint
# from langchain.llms import HuggingFacePipeline 
# from transformers import AutoModelForCausalLM, AutoTokenizer, pipeline
# import torch

# def get_conversation_chain(vectorstore):
#     # Load the model and tokenizer
#     model_name = "microsoft/phi-2"
#     tokenizer = AutoTokenizer.from_pretrained(model_name)
#     model = AutoModelForCausalLM.from_pretrained(model_name)

#     # Force the model to run on CPU
#     device = torch.device("cpu")  # Explicitly set device to CPU
#     model.to(device)  # Move the model to CPU

#     # Create a HuggingFacePipeline instance
#     hf_pipeline = pipeline(
#         "text-generation",
#         model=model,
#         tokenizer=tokenizer,
#         device=-1,  # Use -1 for CPU
#         torch_dtype=torch.float32,  # Use FP32 for CPU
#         batch_size=1  # Reduce batch size to minimize memory usage
#     )
    
#     # Use the HuggingFacePipeline class correctly
#     llm = HuggingFacePipeline(pipeline=hf_pipeline)

#     # Wrap the FAISS vector store in a retriever
#     retriever = vectorstore.as_retriever() # Correct usage

#     # Create memory and conversation chain
#     memory = ConversationBufferMemory(memory_key='chat_history', return_messages=True)
#     conversation_chain = ConversationalRetrievalChain.from_llm(
#         llm=llm,
#         retriever=retriever,  # Pass the retriever, not the vector store
#         memory=memory
#     )
#     return conversation_chain





def get_pdf_text(pdf_docs):
    text = ''
    for pdf in pdf_docs:
        pdf_reader = PdfReader(pdf)
        for page in pdf_reader.pages:
            text += page.extract_text() or ''
    return text

def get_text_chunks(raw_text):
    text_splitter = RecursiveCharacterTextSplitter(
        chunk_size=1000,
        chunk_overlap=200,
        separators=["\n\n", "\n", " ", ""]
    )
    text_chunks = text_splitter.split_text(raw_text)
    return text_chunks

def get_vectorstore(text_chunks):
    embeddings = HuggingFaceEmbeddings(model_name="sentence-transformers/all-mpnet-base-v2")
    vectorstore = FAISS.from_texts(text_chunks, embeddings)
    # vectorstore = Chroma.from_texts(texts=text_chunks, embedding=embeddings, persist_directory="./chroma_db")
    return vectorstore

from langchain_community.llms import HuggingFaceEndpoint  # Correct import

def get_conversation_chain(vectorstore):
    llm = HuggingFaceEndpoint(
        repo_id="microsoft/phi-2",
        task="text-generation",
        temperature=0.5,
        model_kwargs={
            "max_length": 512,
            "trust_remote_code": True
        }
    )
    
    memory = ConversationBufferMemory(
        memory_key="chat_history",
        return_messages=True,
        output_key='answer'  # Add explicit output key
    )
    
    conversation_chain = ConversationalRetrievalChain.from_llm(
        llm=llm,
        retriever=vectorstore.as_retriever(),
        memory=memory,
        return_source_documents=True,  # Add source document tracking
        verbose=True  # Helpful for debugging
    )
    return conversation_chain



def  handle_userinput(user_question):
    response = st.session_state.conversation({'question': user_question})
    # st.write(response)
    st.session_state.chat_history = response['chat_history']

    for i, message in enumerate(st.session_state.chat_history):
        if i%2 == 0:
            st.write(user_template.replace("{{MSG}}", message.content), unsafe_allow_html=True)
        else:
            st.write(bot_template.replace("{{MSG}}", message.content), unsafe_allow_html=True)

def main():
    load_dotenv()
    st.set_page_config(page_title="RAG PDF CHATBOT", page_icon=":books:")

    st.write(css, unsafe_allow_html=True)

    if 'conversation' not in st.session_state:
        st.session_state.conversation = None

    if "chat_history" not in st.session_state:
        st.session_state.chat_history = None


    st.header("PDF Chatbot :books:")
    user_question = st.text_input("Ask your question: ")

    if user_question:
        handle_userinput(user_question)

    with st.sidebar:
        st.subheader("Your documents")
        pdf_docs = st.file_uploader("Upload your pdf file and click on process.", accept_multiple_files=True)

        if st.button("Process"):
            with st.spinner('Processing...'):
                # Get PDF text
                
                raw_text = get_pdf_text(pdf_docs)

                # Create chunks
                text_chunks = get_text_chunks(raw_text)

                # Store in vector database
                vectorstore = get_vectorstore(text_chunks)

                #create conversation chain
                st.session_state.conversation = get_conversation_chain(vectorstore)

    # st.session_state.conversation            
if __name__ == '__main__':
    main()
