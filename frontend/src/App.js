import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import MainPage from "./pages/MainPage";
import SearchPage from "./pages/SearchPage";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/" element={<MainPage />} />
          <Route path="/search/:name" element={<SearchPage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
