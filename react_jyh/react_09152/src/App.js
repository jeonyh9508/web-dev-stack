import { useState } from "react";

function App() {
  // let mode = "WELCOME";
  let [mode, setMode] = useState("WELCOME");
  let [id, setId] = useState(null);

  // back 단에서 ai 사용할때?
  let [nextId, setNextId] = useState(4);
  let content = null;

  let [m_topics, setTopics] = useState([
    { id: 1, title: "HTML", body: "i am HTML" },
    { id: 2, title: "CSS", body: "you are CSS" },
    { id: 3, title: "JS", body: "he is JS" },
  ]);

  if (mode === "WELCOME") {
    content = <Article title="welcome mode state" body="STATE WEB"></Article>;
  } else if (mode === "READ") {
    let title = null;
    let body = null;
    for (let i = 0; i < m_topics.length; i++) {
      if (m_topics[i].id === id) {
        title = m_topics[i].title;
        body = m_topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
  } else if (mode === "CREATE") {
    content = (
      <Create
        onCreate={(title, body) => {
          let newTopic = { id: nextId, title: title, body: body };

          // m_topics배열을 newTopics에 전체 복사(...m_topics)
          let newTopics = [...m_topics];
          newTopics.push(newTopic);
          setTopics(newTopics);

          setMode("READ");
          setId(nextId);
          setNextId(nextId + 1);
        }}
      ></Create>
    );
  }

  return (
    <div className="App">
      <Header
        title="React!!"
        onChangeMode={() => {
          setMode("WELCOME");
        }}
      />
      <Nav
        topics={m_topics}
        onChangeMode={(id) => {
          // mode = "READ";
          // mode 가 변경되어도 새로고침이 되지않아 적용되지 않음
          // console.log(mode);
          setMode("READ");
          setId(id);
        }}
      />
      <Article title="WelCome" body="Hello ! React !! Web !!!" />

      {content}

      <a
        href="/create"
        onClick={(event) => {
          event.preventDefault();
          setMode("CREATE");
        }}
      >
        Create
      </a>

      <input
        type="button"
        value="Delete"
        onClick={(e) => {
          let newTopics = [];
          for (let i = 0; i < m_topics.length; i++) {
            // m_topics에 지정되어 있는 id 와 지우려는 id 가 다른 경우 에만 newTopics 에 push
            if (m_topics[i].id !== id) {
              newTopics.push(m_topics[i]);
            }
          } // for 문 종료

          setTopics(newTopics);
        }}
      />
    </div>
  );
}

function Create(props) {
  return (
    <article>
      <h2>Create!!</h2>
      <form
        onSubmit={(event) => {
          event.preventDefault();
          let title = event.target.title.value;
          let body = event.target.body.value;
          console.log(title + body);
          props.onCreate(title, body);
        }}
      >
        <input type="text" name="title" placeholder="input title" />
        <br />
        <textarea name="body"></textarea>
        <br />
        <input type="submit" value="New Create!" />
      </form>
    </article>
  );
}
function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={() => {
            alert("나는 헤더");
          }}
        >
          {props.title}
        </a>
      </h1>
      <h1>
        <a
          href="/"
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Nav(props) {
  let lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(Number(event.target.id));
            // props.onChangeMode(parseInt(event.target.id));
          }}
        >
          {t.title} / {t.body}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ul>{lis}</ul>
    </nav>
  );
}
function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      <p>{props.body}</p>
    </article>
  );
}
export default App;
