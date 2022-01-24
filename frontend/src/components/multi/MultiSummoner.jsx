import axios from "axios";
import { useEffect, useState } from "react/cjs/react.development";
import styled from "styled-components";
import LeagueInfo from "../Summoner/LeagueInfo";

const ContentWrapper = styled.div`
  text-align: left;
  display: flex;
  max-width: 1000px;
  margin: auto;
  padding: 7px;
`;

const ProfileIconImg = styled.img`
  height: 30px;
  width: 30px;
  margin: 0px 5px;
`;

const SummonerInfo = styled.div`
  width: 150px;
`;

const SummonerName = styled.span`
  font-size: 16px;
  font-weight: 800;
`;

export default function ({ myName }) {
  const userName = myName;
  const url = "/reactSearch/" + userName;
  const [{ name, profileIconUrl, soloRank = {} }, setSummoner] = useState([]);

  useEffect(() => {
    axios
      .get(url)
      .then((result) => {
        setSummoner(result.data);
      })
      .catch(() => {
        console.log("실패");
      });
  }, [url]);
  return (
    <>
      {name && (
        <>
          <ContentWrapper>
            <ProfileIconImg src={profileIconUrl}></ProfileIconImg>
            <SummonerInfo>
              <SummonerName>{name}</SummonerName>
            </SummonerInfo>
          </ContentWrapper>
          <ContentWrapper>
            <LeagueInfo soloRank={soloRank} />
          </ContentWrapper>
        </>
      )}
    </>
  );
}
