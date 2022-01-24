import axios from "axios";
import { useState, useEffect } from "react";
import styled from "styled-components";
import MultiMatch from "./MultiMatch";

const ContentWrapper = styled.div`
  display: table-cell;
  vertical-align: middle;
  float: left;
  width: 300px;
`;

export default function ({ myName }) {
  const url = "/api/matches/" + myName + "/solo";
  const [match, setMatch] = useState([]);

  useEffect(() => {
    axios
      .get(url)
      .then((res) => {
        setMatch(res.data);
      })
      .catch(() => {
        console.log("실패");
      });
  }, []);

  return (
    <>
      <ContentWrapper>
        {match.map((m, idx) => (
          <>{idx < 5 && <MultiMatch match={m} />}</>
        ))}
      </ContentWrapper>
      <ContentWrapper>
        {match.map((m, idx) => (
          <>{idx < 10 && idx >= 5 && <MultiMatch match={m} />}</>
        ))}
      </ContentWrapper>
    </>
  );
}
