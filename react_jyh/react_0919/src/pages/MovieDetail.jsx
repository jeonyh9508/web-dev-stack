import React from "react";
import { useLocation, useParams } from "react-router-dom";

const IMG_BASE_URL = "https://image.tmdb.org/t/p/w1280/";
export default function MovieDetail() {
  const { title } = useParams();
  const { state } = useLocation();
  return (
    <div className="page-container">
      <img
        src={IMG_BASE_URL + state.poster_path}
        style={{ width: "300px", height: "450px" }}
      />
      <div>
        <h3>{title}</h3>
        <h4>{state.vote_average}</h4>
      </div>
    </div>
  );
}
