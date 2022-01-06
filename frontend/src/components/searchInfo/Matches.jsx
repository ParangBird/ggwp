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
  const url = "/api/matches/" + userName;

  const [match, setMatch] = useState([]);
  useEffect(() => {
    axios
      .get(url)
      .then((res) => {
        setMatch(res.data);
        console.log(res.data);
      })
      .catch(() => {
        console.log("실패");
      });
  }, [url]);

  const setMatchInfo = (match) => {
    for (let i = 0; i < 10; i++) {
      if (match.summonerName == match.participants[i].summonerName) {
        return <Match participant={match.participants[i]} match={match} />;
      }
    }
  };

  return (
    <ContentWrapper>
      {match.map((m) => (
        <>{setMatchInfo(m)}</>
      ))}
    </ContentWrapper>
  );
}
