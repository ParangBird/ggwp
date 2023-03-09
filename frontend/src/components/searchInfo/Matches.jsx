import axios from "axios";
import { useEffect } from "react";
import { useParams } from "react-router-dom";
import { useState } from "react/cjs/react.development";
import styled from "styled-components";
import Match from "./Match";

const ContentWrapper = styled.div`
  text-align: left;
  max-width: 1000px;
  margin: 20px auto;
  padding: 7px;
`;

export default function () {
  const userName = useParams().name;
  const [url, setUrl] = useState("/api/matches/" + userName);
  const [match, setMatch] = useState([]);

  useEffect(() => {
    setUrl("/api/matches/" + userName);
  }, [userName]);

  useEffect(() => {
    axios
      .get(url)
      .then((res) => {
        setMatch(res.data);
      })
      .catch(() => {
        console.log("실패");
      });
  }, [url]);

  const all = () => {
    setUrl("/api/matches/" + userName);
  };

  const solo = () => {
    setUrl(url + "/solo");
  };

  return (
    <ContentWrapper>
      {/*<button onClick={all}>all</button>
      <button onClick={solo}>solo</button>*/}
      {match.map((m) => (
        <Match match={m} />
      ))}
    </ContentWrapper>
  );
}
