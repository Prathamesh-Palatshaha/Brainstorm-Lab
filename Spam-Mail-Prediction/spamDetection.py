import pickle
import streamlit as st

from PreprocessingFunctions import lemmatize_words, remove_punctuations, remove_stopwords



model = pickle.load(open("spam.pkl", "rb"))
feat = pickle.load(open("feature.pkl", "rb"))

def main():
    st.title("Email Spam Classification App")
    st.subheader("Build With Streamlit and Python")
    input_mail = st.text_input("Enter a text: ")

    if st.button("Predict"):
        clean = [lemmatize_words(remove_stopwords(remove_punctuations(input_mail)))]
        transform_ = feat.transform(clean)
        prediction = model.predict(transform_)
        if prediction == 1:
            st.error("This is a spam mail")
        else:
            st.success("This is ham mail")


main()
