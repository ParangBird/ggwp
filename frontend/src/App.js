import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import MainPage from "./pages/MainPage";
import SearchPage from "./pages/SearchPage";
import EmptyPage from "./pages/EmptyPage";

function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Header />
                <Routes>
                    <Route exact path="/" element={<MainPage />} />
                    <Route path="/search/:name" element={<SearchPage />} />
                    <Route path="*" element={<EmptyPage />} />
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;