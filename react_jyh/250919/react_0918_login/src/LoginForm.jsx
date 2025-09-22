import React from "react";

const LoginForm = ( 
    { email, handleEmail, emailValid, 
        pw, handlePw, pwValid, clickConfirm } ) => {

    return(

        <div className="page">

            <div className="titleWrap">
                이메일과 비밀번호를<br/>입력 해 주세요
            </div>

            <div className="contentWrap">
                <div className="inputTitle">이메일 주소</div>

                <div className="inputWrap">
                    <input className="input"
                           placeholder="이메일을 입력하세요"
                           value={email}
                           onChange={handleEmail}/>
                </div>

                <div className="errorMessageWrap">
                    {
                        !emailValid && (
                           <div>이메일 주소를 입력해야 합니다 </div>
                        )
                    }
                </div>

                <div className="inputTitle">비밀번호</div>
                <div className="inputWrap">
                    <input type="password"
                           className="input" 
                           placeholder="비밀번호를 입력하세요"
                           value={pw}
                           onChange={handlePw}/>
                </div>

                <div className="errorMessageWrap">
                    {
                        !pwValid && (
                            <div>비밀번호를 입력해야 합니다</div>
                        )
                    }
                </div>

            </div>

            <div>
                <button className="bottomButton"
                        onClick={clickConfirm}>확인</button>
            </div>

        </div>

    )

}

export default LoginForm;