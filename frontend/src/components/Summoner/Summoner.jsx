import axios from "axios";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react/cjs/react.development";
import styled from "styled-components";
import LeagueInfo from "./LeagueInfo";
import RenewButton from "./RenewButton";

const ContentWrapper = styled.div`
  text-align: left;
  display: flex;
  max-width: 1000px;
  margin: 20px auto;
  padding: 7px;
`;

const ProfileIconImg = styled.img`
  height: 100px;
  width: 100px;
  margin: 0px 15px 0px 20px;
`;

const SummonerInfo = styled.div`
  margin-right: 15px;
`;

const SummonerName = styled.span`
  font-size: 25px;
  font-weight: 800;
`;

export default function Summoner() {
  const userName = useParams().name;
  const url = "/reactSearch/" + userName;
  // const [summoner, setSummoner] = useState([]);
  const [{ name, profileIconUrl, summonerLevel, soloRank = {}, flexRank = {} }, setSummoner] = useState([]);
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

  // const { id, name, profileIconUrl, summonerLevel, soloRank = {}, flexRank = {} } = summoner;

  return (
    <>
      <ContentWrapper>
        <ProfileIconImg src={profileIconUrl}></ProfileIconImg>
        <SummonerInfo>
          <SummonerName>{name}</SummonerName>
          <div>레벨: {summonerLevel}</div>
          <RenewButton />
        </SummonerInfo>
      </ContentWrapper>
      <ContentWrapper>
        <LeagueInfo soloRank={soloRank} flexRank={flexRank} />
      </ContentWrapper>
    </>
  );
}
