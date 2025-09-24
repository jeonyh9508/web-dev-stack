const express = require("express"); // Express 불러오기
const mysql = require("mysql2"); // MySQL 불러오기
const cors = require("cors"); // CORS 미들웨어

const app = express(); // Express app 생성
app.use(cors()); // CORS 허용
app.use(express.json()); // JSON 요청 파싱

// DB 연결 설정
const db = mysql.createConnection({
  host: "localhost", // 데이터베이스 호스트
  user: "root", // MySQL 사용자
  password: "qwer1234", // 비밀번호
  database: "signup", // 사용 데이터베이스 이름
});

// DB 접속 및 쿼리 요청
app.post("/signup", (req, res) => {
  // 쿼리문 작성 컬럼은 백콧 ``
  const sql = "INSERT INTO login (`name`, `email`, `password`) VALUES (?)";
  const values = [req.body.name, req.body.email, req.body.password];
  db.query(sql, [values], (err, data) => {
    if (err) {
      console.error("err : " + err);
      return res.json("Error");
    }
    return res.json(data);
  });
});

// 로그인 요청
app.post("/login", (req, res) => {
  // WHERE 조건 email, password 매칭
  const sql = "SELECT * FROM login WHERE `email`= ? AND `password`= ?";
  // frontend에서 값 가져오기
  const values = [req.body.email, req.body.password];
  // query 조회 성공 / 실패 여부
  db.query(sql, values, (err, data) => {
    if (err) {
      return res.json("Error");
    }
    if (data.length > 0) {
      return res.json("Success");
    } else {
      return res.json("Fail");
    }
  });
});

// 서버 시작
app.listen(3000, () => {
  console.log("listening");
});
