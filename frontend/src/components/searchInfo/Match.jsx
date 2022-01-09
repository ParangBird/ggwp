import { getGameType, winOrLose, getKDA, getTimeInfo, getTimeHasBeen, getKillEngage, getCsPerMin } from "../common/cal";
import { spell } from "../common/spells";
import { perkInfo } from "../common/perkInfo";
import styled from "styled-components";
import { OverlayTrigger, Tooltip } from "react-bootstrap";
import { getItemImgUrl, getChampImgUrl, getPerkImgUrl, getSpellImgUrl } from "../common/imgSource";
import SmallImg from "./SmallImg";
import ImgBoxN_2 from "./ImgBoxN_2";
import { Link } from "react-router-dom";

const ContentWrapper = styled.div`
  border: 1px solid #b5babf;
  background-color: ${(props) => {
    if (props.win) {
      return "#d0e4ff";
    } else {
      return "#FFEEEE";
    }
  }};
  display: table;
  margin-bottom: 10px;
  width: 1000px;
  height: 100px;
`;

const MatchStats = styled.div`
  display: table-cell;
  vertical-align: middle;
  text-align: center;
  width: 70px;
`;

const ChampionImgBig = styled.div`
  background-image: url(${(props) => props.img});
  background-size: cover;
  display: table-cell;
  width: 48px;
  height: 48px;
`;

const Spell = styled.div`
  display: table-cell;
  vertical-align: middle;
  width: 29px;
  padding-left: 5px;
`;

export default function ({ match }) {
  const spell1 = () => {
    const res = spell.find((e) => {
      if (e.key == match.spell1) return true;
    });
    return res ? res.id : res;
  };

  const spell2 = () => {
    const res = spell.find((e) => {
      if (e.key == match.spell2) return true;
    });
    return res ? res.id : res;
  };

  const perkMain = perkInfo.find((e) => {
    if (e.id == match.perkMain) return true;
  });

  const perkSub = perkInfo.find((e) => {
    if (e.id == match.perkSub) return true;
  });

  const itemImgUrls = [
    getItemImgUrl(match.item0),
    getItemImgUrl(match.item3),
    getItemImgUrl(match.item1),
    getItemImgUrl(match.item4),
    getItemImgUrl(match.item2),
    getItemImgUrl(match.item5),
    getItemImgUrl(match.item6),
  ];

  const champImgUrls = [
    getChampImgUrl(match.blueChamp1),
    getChampImgUrl(match.redChamp1),
    getChampImgUrl(match.blueChamp2),
    getChampImgUrl(match.redChamp2),
    getChampImgUrl(match.blueChamp3),
    getChampImgUrl(match.redChamp3),
    getChampImgUrl(match.blueChamp4),
    getChampImgUrl(match.redChamp4),
    getChampImgUrl(match.blueChamp5),
    getChampImgUrl(match.redChamp5),
  ];

  return (
    <ContentWrapper win={match.win}>
      <MatchStats>
        <span style={{ fontSize: "13px" }}>{getGameType(match.queueId)}</span>
        <br />
        <span style={{ fontSize: "15px" }}>{winOrLose(match.win)}</span>
      </MatchStats>
      <MatchStats>
        <span style={{ fontSize: "13px" }}>{getTimeHasBeen(match.gameEndTimestamp)}</span>
        <br />
        <span style={{ fontSize: "13px" }}>{getTimeInfo(match.time)}</span>
      </MatchStats>
      <MatchStats style={{ width: "110px" }}>
        <ChampionImgBig img={getChampImgUrl(match.champ)}></ChampionImgBig>
        <Spell>
          <SmallImg url={getSpellImgUrl(spell1())} />
          <SmallImg url={getSpellImgUrl(spell2())} />
        </Spell>
        <Spell>
          <OverlayTrigger
            placement="right"
            overlay={(props) => (
              <Tooltip id="button-tooltip-2" {...props}>
                [{perkMain.name}]<p />
                {perkMain.shortDesc}
              </Tooltip>
            )}
          >
            <div>
              <SmallImg url={getPerkImgUrl(perkMain.iconPath)} />
            </div>
          </OverlayTrigger>
          <OverlayTrigger
            placement="right"
            overlay={(props) => (
              <Tooltip id="button-tooltip-2" {...props}>
                [{perkSub.name}]
              </Tooltip>
            )}
          >
            <div>
              <SmallImg style={{ width: "16px", height: "16px", margin: "3px" }} url={getPerkImgUrl(perkSub.iconPath)} />
            </div>
          </OverlayTrigger>
        </Spell>
        {match.champ}
      </MatchStats>
      <MatchStats style={{ width: "90px" }}>
        {match.kills} / {match.deaths} / {match.assists}
        <br />
        {getKDA(match.kills, match.deaths, match.assists)}
      </MatchStats>
      <ImgBoxN_2 row={4} count={7} img={itemImgUrls} />
      <ImgBoxN_2 row={1} />
      <ImgBoxN_2 row={5} count={10} img={champImgUrls} />
      <MatchStats style={{ width: "90px" }}>
        <span style={{ fontSize: "13px" }}>레벨 {match.level}</span>
        <br />
        <span style={{ fontSize: "12.5px" }}>킬관여 {getKillEngage(match.kills + match.assists, match.totalKill)}%</span>
      </MatchStats>
      <MatchStats style={{ width: "60px" }}>
        <span style={{ fontSize: "13px" }}>CS {match.cs}</span>
        <br />
        <span style={{ fontSize: "13px" }}>분당 ({getCsPerMin(match.cs, match.time)})</span>
      </MatchStats>
      <br />
    </ContentWrapper>
  );
}
