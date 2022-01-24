import axios from "axios";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react/cjs/react.development";
import styled from "styled-components";
import LeagueInfo from "../Summoner/LeagueInfo";
import MultiMatches from "./MutiMatches";

const ContentWrapper = styled.div`
  text-align: left;
  width: 1000px;
  margin: auto;
`;

const InnerDiv = styled.div`
  display: table;
`;

const MatchDiv = styled.div`
  display: table-cell;
  vertical-align: middle;
  height: 150px;
`;

const ProfileIconImg = styled.img`
  display: table-cell;
  height: 30px;
  width: 30px;
  margin: 0px 5px 5px 0px;
`;

const SummonerInfo = styled.div`
  display: table-cell;
  vertical-align: middle;
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
        <ContentWrapper>
          <InnerDiv>
            <ProfileIconImg src={profileIconUrl}></ProfileIconImg>
            <SummonerInfo>
              <Link style={{ textDecoration: "none" }} to={`/search/${name}`}>
                <SummonerName>{name}</SummonerName>
              </Link>
            </SummonerInfo>
          </InnerDiv>
          <InnerDiv>
            <MatchDiv>
              <LeagueInfo imgSize={70} soloRank={soloRank} />
            </MatchDiv>
            <MultiMatches myName={name} />
          </InnerDiv>
        </ContentWrapper>
      )}
    </>
  );
}
