import React, { useState } from "react";
import InputField from "./InputField";
// import { useState } from "react";

const MovieForm = ({ addMovie }) => {
  const [movieTitle, setMovieTitle] = useState("");
  const [movieYear, setMovieYear] = useState("");

  const [titleError, setTitleError] = useState("");
  const [yearError, setYearError] = useState("");

  const vaildateForm = () => {
    let validated = true;

    if (!movieTitle) {
      setTitleError("영화 제목을 입력하세요.");
      validated = false;
    }

    if (!movieYear) {
      setYearError("개봉 연도를 입력하세요.");
      validated = false;
    }

    return validated;
  };

  const onSubmit = (e) => {
    e.preventDefault();

    if (vaildateForm()) {
      addMovie({
        id: Date.now(),
        title: movieTitle,
        year: movieYear,
      });
      setTitleError("");
      setYearError("");
      setMovieTitle("");
      setMovieYear("");
    }
  };
  return (
    <form onSubmit={onSubmit}>
      <InputField
        type="text"
        placeholder="영화 제목"
        value={movieTitle}
        onChange={(e) => {
          setMovieTitle(e.target.value);
        }}
        errorMessage={titleError}
      />

      <InputField
        type="number"
        placeholder="개봉 연도"
        value={movieYear}
        onChange={(e) => {
          setMovieYear(e.target.value);
        }}
        errorMessage={yearError}
      />
      <input type="submit" value="영화 등록" />
    </form>
  );
};
export default MovieForm;
/*
export default function MovieForm(){}
*/
