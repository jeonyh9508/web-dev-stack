import React, { useState } from "react";
import MovieForm from "../components/MovieForm";
import Movie from "../components/Movie";

const Movies = () => {
  const [movies, setMovies] = useState([]);

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
    // }
    setMovies([...movies, movie]);
  };

  return (
    <div>
      <h1>Movie List</h1>
      <MovieForm addMovie={addMovie} />
      {renderMovies}
    </div>
  );
};
export default Movies;
