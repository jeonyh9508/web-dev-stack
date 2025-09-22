import React, { useState } from "react";
import { Link } from "react-router-dom";
import LoginValidation from "./LoginValidation";
import axios from 'axios';

function Signup(){

    const [values, setValues] = 
            useState({name:'', email:'', password:''})

    const [errors, setErrors] = useState();

    const handleSubmit = ( e ) => {
        e.preventDefault();
        setErrors( LoginValidation(values) )

        axios.post( 'http://localhost:3000/signup', values )
             .then( res => { 
                alert("가입성공");
                window.location.href='/'; 
             } )
    }

    const handleInput = (e) => {
        setValues( { ...values, [e.target.name]:[e.target.value] } )
    }        

    return(
         <div className='d-flex justify-content-center align-items-center bg-primary vh-100'>
            <div className='bg-white p-3 rounded w-25'>

		<h2>Sign-Up</h2>

                <form action="" onSubmit={handleSubmit}>
                    <div className='mb-3'>
                        <label>Name</label>
                        <input placeholder='enter name'
                               onChange={handleInput}
                               name="name"/>
                    </div>

                    <div className='mb-3'>
                        <label>Email</label>
                        <input placeholder='enter email'
                               onChange={handleInput}
                               name="email"/>
                    </div>

                    <div className='mb-3'>
                        <label>Password</label>
                        <input type="password" placeholder='enter password'
                               onChange={handleInput}
                               name="password"/>
                    </div>

                    <button type="submit" className='btn btn-success'>가입완료</button>

                    <p>계정이 없으신가요??</p>
                    <Link to="/" className='btn btn-default border'>로그인</Link>
                </form>
            </div>
        </div>
    )
}

export default Signup;