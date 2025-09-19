import React from "react";
import mylogo from "../img/logo_img.PNG";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <div className="header-container">
      <div className="header-wrap">
        <div className="header-left-wrap">
          <Link to="/">
            <img src={mylogo} />
          </Link>
          <ul>
            <li>
              <Link className="header-nav-item" to="/movie">
                Movies
              </Link>
            </li>
            <li>
              <Link className="header-nav-item" to="/tv">
                Program
              </Link>
            </li>
            <li>
              <Link className="header-nav-item" to="/person">
                Celeb
              </Link>
            </li>
          </ul>
        </div>
        <div className="header-right-wrap"></div>
      </div>
    </div>
  );
}
