import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import MainPage from "./pages/MainPage";
import SearchPage from "./pages/SearchPage";
import EmptyPage from "./pages/EmptyPage";
import RankingPage from "./pages/RankingPage";
import RegisterPage from "./pages/RegisterPage";
import LoginPage from "./pages/LoginPage";
import FindPage from "./pages/FindPage";
import MultiPage from "./pages/MultiPage";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/" element={<MainPage />} />
          <Route path="/search/:name" element={<SearchPage />} />
          <Route path="/ranking" element={<RankingPage />} />
          <Route path="/ranking/:summonerName" element={<RankingPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/find" element={<FindPage />} />
          <Route path="/multi" element={<MultiPage />} />
          <Route path="/multi/:name" element={<MultiPage />} />
          <Route path="*" element={<EmptyPage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
