import "./index.css";

import Movie from "./components/Movie";
import { dummy } from "./movieDummy";

function App() {
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

export default App;
