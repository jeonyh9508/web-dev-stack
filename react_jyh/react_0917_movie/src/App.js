import { useState } from "react";
import Movie from "./components/Movie";
import "./index.css";
import MovieForm from "./components/MovieForm";
import Navbar from "./components/Navbar";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  // const [movieTitle, setMovieTitle] = useState("");
  // const [movieYear, setMovieYear] = useState("");
  const [movies, setMovies] = useState([]);
  // const movies = [
  //   { title: "해리포터1", year: 2001 },
  //   { title: "쥬라기월드", year: 2025 },
  // ];
  const removeMovie = (id) => {
    // alert(id);
    setMovies(
      movies.filter((movie) => {
        return movie.id !== id;
      })
    );
  };

  const renderMovies = movies.length
    ? movies.map((movie) => {
        return <Movie movie={movie} removeMovie={removeMovie} />;
      })
    : "등록된 영화가 없습니다.";

  const addMovie = (movie) => {
    // if (movieTitle.trim() && movieYear.trim()) {
    // alert(movieTitle + "/" + movieYear);
    // let title = movieTitle;
    // let year = movieYear;
    // setMovies([...movies, { title, year }]);
    setMovies([...movies, movie]);

    // }
  };
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Routes>
          <Route
            path="/movies"
            element={
              <div>
                <h1>Movie List</h1>
                <MovieForm addMovie={addMovie} />
                {renderMovies}
              </div>
            }
          />
          <Route path="/users" element={<h1>User 컴포넌트</h1>} />
          <Route path="/" element={<h1>Home 컴포넌트</h1>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
