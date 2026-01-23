import streamlit as st
import pandas as pd
import ast

# ---------------------------------------------------
# 🎬 Title
# ---------------------------------------------------
st.set_page_config(page_title="Movie Recommender System", layout="centered")
st.title("🎬 Movie Recommender System")
st.caption("Select your preferred language and genre to get top-rated movie recommendations instantly!")

# ---------------------------------------------------
# 📂 Load and preprocess data (cached for speed)
# ---------------------------------------------------
@st.cache_data
def load_and_preprocess():
    # ✅ Load dataset safely
    try:
        movies = pd.read_csv("movies.csv", encoding="utf-8")
    except UnicodeDecodeError:
        movies = pd.read_csv("movies.csv", encoding="latin1")

    # ✅ Extract genres safely
    def get_genres(x):
        if isinstance(x, str):
            try:
                genres = [d['name'] for d in ast.literal_eval(x)]
                return ", ".join(genres)
            except:
                return x  # already plain text
        return ''

    if 'genres' in movies.columns:
        movies['genres_cleaned'] = movies['genres'].apply(get_genres)
    elif 'genres_cleaned' not in movies.columns:
        movies['genres_cleaned'] = ''

    # ✅ Clean missing values
    for col in ['title', 'vote_average', 'original_language', 'overview']:
        if col not in movies.columns:
            movies[col] = ''
    movies['overview'] = movies['overview'].fillna('')
    movies['vote_average'] = movies['vote_average'].fillna(0)
    movies['original_language'] = movies['original_language'].fillna('Unknown')

    # ✅ Keep essential columns
    movies = movies[['title', 'vote_average', 'genres_cleaned', 'original_language', 'overview']]
    return movies


movies = load_and_preprocess()

# ---------------------------------------------------
# 🌐 Language and Genre Selection
# ---------------------------------------------------
available_languages = {
    'Tamil': 'Tamil',
    'English': 'English',
    'Hindi': 'Hindi',
    'Malayalam': 'Malayalam',
    'Telugu': 'Telugu'
}


selected_languages = st.multiselect(
    "🌍 Select Language(s):",
    options=list(available_languages.keys()),
    default=['English']
)

fixed_genres = [
    "Action", "Adventure", "Comedy", "Crime and mystery",
    "Fantasy", "Horror", "Romance", "Science fiction", "Thriller"
]
selected_genre = st.selectbox("🎭 Select Genre:", fixed_genres)

# ---------------------------------------------------
# 🔍 Filter and Recommend
# ---------------------------------------------------
if st.button("🎥 Show Recommendations"):
    if not selected_languages:
        st.warning("Please select at least one language.")
    else:
        selected_lang_codes = [available_languages[l] for l in selected_languages]

        filtered = movies[
            (movies['original_language'].isin(selected_lang_codes)) &
            (movies['genres_cleaned'].str.contains(selected_genre, case=False, na=False))
        ]

        top_movies = filtered.sort_values(by='vote_average', ascending=False).head(10)

        if top_movies.empty:
            st.error("❌ No movies found for this combination. Try another genre or language.")
        else:
            st.success(f"Top {len(top_movies)} {selected_genre} Movies for {', '.join(selected_languages)}:")
            for _, row in top_movies.iterrows():
                st.markdown(f"### 🎬 {row['title']}")
                st.markdown(f"⭐ **Rating:** {row['vote_average']}")
                st.markdown(f"🎭 **Genres:** {row['genres_cleaned']}")
                st.markdown(f"🌐 **Language:** {row['original_language']}")
                st.markdown(f"📝 **Overview:** {row['overview'][:250]}...")
                st.markdown("---")
