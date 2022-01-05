import axios from "axios";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react/cjs/react.development";
import styled from "styled-components";

const ProfileWrapper = styled.div`
  text-align: left;
  display: flex;
  max-width: 1000px;
  margin: auto;
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
  const name = useParams().name;
  const url = "/reactSearch/" + name;
  const [summoner, setSummoner] = useState("");

  useEffect(() => {
    axios
      .get(url)
      .then((result) => {
        console.log(result.data);
        setSummoner(result.data);
      })
      .catch(() => {
        console.log("실패");
      });
  }, [url]);

  return (
    <ProfileWrapper>
      <ProfileIconImg src={summoner.profileIconUrl}></ProfileIconImg>
      <SummonerInfo>
        <SummonerName>{summoner.name}</SummonerName>
        <div>레벨: {summoner.summonerLevel}</div>
      </SummonerInfo>
    </ProfileWrapper>
  );
}
