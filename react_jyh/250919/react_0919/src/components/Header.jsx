import React from "react";

import mylogo from '../img/logo_img.PNG';
import { Link } from "react-router-dom";

export default function Header(){

    return(
        <div className="header-container">
            <div className="header-wrap">
                <div className="header-left-wrap">
                    <Link to='/'><img src={mylogo}/></Link>

                    <ul>
                        <li>
                            <Link className="header-nav-item" to='/movie'>영화</Link>
                        </li>

                        <li>
                            <Link className="header-nav-item" to='/tv'>TV프로그램</Link>
                        </li>

                        <li>
                            <Link className="header-nav-item" to='/person'>인물</Link>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    )

}