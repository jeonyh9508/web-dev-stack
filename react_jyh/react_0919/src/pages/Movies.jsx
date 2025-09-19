import React from "react";
import { dummy } from "../movieDummy";
import Movie from "../components/Movie";

export default function Moives() {
  return (
    <div className="app-container">
      {dummy.results.map((item) => {
        return (
          <Movie
            title={item.title}
            vote_average={item.vote_average}
            poster_path={item.poster_path}
          />
        );
      })}
    </div>
  );
}
