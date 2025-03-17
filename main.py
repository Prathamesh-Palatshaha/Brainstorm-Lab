import streamlit as st
import pandas as pd
import torch
import torch.nn as nn
import pickle

# Load the saved model
class MalwareNet(nn.Module):
    def __init__(self, input_size):
        super().__init__()
        self.block1 = nn.Sequential(
            nn.Linear(input_size, 512),
            nn.BatchNorm1d(512),
            nn.ELU(),
            nn.Dropout(0.5)
        )
        self.attention = nn.MultiheadAttention(512, 4)
        self.block2 = nn.Sequential(
            nn.Linear(512, 256),
            nn.LayerNorm(256),
            nn.SiLU(),
            nn.Dropout(0.4)
        )
        self.block3 = nn.Sequential(
            nn.Linear(256, 128),
            nn.BatchNorm1d(128),
            nn.ELU(),
            nn.Dropout(0.3)
        )
        self.output = nn.Sequential(
            nn.Linear(128, 1),
            nn.Sigmoid()
        )
    
    def forward(self, x):
        x = self.block1(x)
        x_att, _ = self.attention(x.unsqueeze(1), x.unsqueeze(1), x.unsqueeze(1))
        x = x + x_att.squeeze(1)
        x = self.block2(x)
        x = self.block3(x)
        return self.output(x)

# Streamlit UI
st.title("Malware Detection System")

uploaded_file = st.file_uploader("Upload INPUT.csv", type=["csv"])
if uploaded_file is not None:
    df = pd.read_csv(uploaded_file)
    st.write("### Preview of Uploaded Data:")
    st.dataframe(df.head())
    
    # Load scaler
    with open("scaler.pkl", "rb") as f:
        scaler = pickle.load(f)
    
    # Define required features
    required_features = ['ldrmodules.not_in_load',
 'handles.nmutant',
 'ldrmodules.not_in_mem',
 'ldrmodules.not_in_init',
 'handles.ntimer',
 'svcscan.nservices',
 'handles.nkey',
 'pslist.avg_threads',
 'handles.nsemaphore',
 'handles.avg_handles_per_proc',
 'svcscan.shared_process_services',
 'handles.nevent',
 'handles.nsection',
 'handles.nhandles',
 'pslist.avg_handlers',
 'handles.nthread',
 'dlllist.ndlls',
 'dlllist.avg_dlls_per_proc']
    
    # Ensure only required features are used
    df_filtered = df[required_features]
    
    # Preprocess data
    df_scaled = scaler.transform(df_filtered)
    df_tensor = torch.tensor(df_scaled, dtype=torch.float32)
    
    # Load model
    input_size = df_tensor.shape[1]
    model = MalwareNet(input_size)
    model.load_state_dict(torch.load("best_model.pth", map_location=torch.device('cpu')))
    model.eval()
    
    # Make predictions
    with torch.no_grad():
        predictions = model(df_tensor).squeeze().numpy()
    
    # Display predictions
    df["Prediction"] = predictions
    df["Malware_Detected"] = df["Prediction"].apply(lambda x: "Yes" if x > 0.5 else "No")
    st.write("### Predictions:")
    st.dataframe(df[["Prediction", "Malware_Detected"]])
    
    # Download predictions
    csv = df.to_csv(index=False).encode("utf-8")
    st.download_button(
        label="Download Predictions as CSV",
        data=csv,
        file_name="predictions.csv",
        mime="text/csv"
    )