# 🎬 Movie Recommender System

A data-driven web application that provides instant, top-rated movie recommendations based on user-selected languages and genres. Built with **Python** and **Streamlit**, this system offers a clean, interactive interface for discovering cinematic gems across various regional and global languages.

## ✨ Features
* **Multi-Language Support:** Filter movies from languages like Tamil, Malayalam, English, Hindi, and Telugu.
* **Genre-Specific Filtering:** Select from popular genres including Action, Horror, Romance, Sci-Fi, and more.
* **Top-Rated Suggestions:** Automatically sorts and displays the top 10 movies based on user ratings.
* **Brief Overviews:** Displays a snapshot of the movie plot, genres, and ratings.
* **High Performance:** Implements `@st.cache_data` for lightning-fast data loading and preprocessing.

---

## 🛠️ Tech Stack
* **Frontend:** [Streamlit](https://streamlit.io/)
* **Data Analysis:** [Pandas](https://pandas.pydata.org/)
* **Language:** Python 3.9+
* **Environment:** VS Code / Terminal

---

## 📦 Installation & Setup

### 1. Clone the Repository

 ### 2. Install Dependencies
 pip install streamlit pandas

 ### 3.Prepare the Dataset
 Ensure your movies.csv file is located in the root directory of the project.

 🎮 How to Run
 In your terminal or VS Code terminal, run the following command:
 streamlit run movie_recommender_app.py

 If you encounter a "command not found" error, use:
 python -m streamlit run movie_recommender_app.py


 📂 Project Structure:

 .
├── movie_recommender_app.py   # Main Streamlit application script
├── movies.csv                 # Dataset containing movie titles, ratings, and genres
├── README.md                  # Project documentation
└── Project_Report.pdf         # Detailed technical report (Optional)
