import styled from "styled-components";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import RecentSearch from "./Summoner/RecentSearch";

const SearchBar = styled.input`
  font-weight: 400;
  height: 45px;
  width: 350px;
  border: 0px;
  padding: 13px;
  border-radius: 10px 0px 0px 10px;
  outline: none;
`;

const SearchButton = styled.button`
  background-color: #30383e;
  padding-top: 3px;
  color: white;
  font-size: 15px;
  font-weight: 600;
  cursor: pointer;
  height: 47px;
  width: 50px;
  border: 0px;
  border-radius: 0px 10px 10px 0px;
`;

export default function SearchSmall() {
  const [name, setName] = useState("");
  const [visible, setVisible] = useState(false);

  const nameChange = (e) => {
    setName(e.target.value);
  };

  const inputClick = () => {
    setVisible(!visible);
  };

  return (
    <div>
      <form>
        <SearchBar onFocus={inputClick} onBlur={inputClick} onChange={nameChange} type="text" placeholder="소환사명"></SearchBar>
        <Link to={`/search/${name}`}>
          <SearchButton>검색</SearchButton>
        </Link>
        <RecentSearch visible={visible} width={"390px"} />
      </form>
    </div>
  );
}
