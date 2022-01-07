import { getGameType, winOrLose, getKDA } from "../common/cal";
import { spell } from "../common/spells";
import { perks } from "../common/perks";
import styled from "styled-components";
import { OverlayTrigger, Tooltip } from "react-bootstrap";
import { getChampImgUrl, getPerkImgUrl, getSpellImgUrl } from "../common/imgSource";

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

const SmallImg = styled.div`
  background-image: url(${(props) => props.img});
  background-size: contain;
  background-repeat: no-repeat;
  text-align: center;
  width: 24px;
  height: 24px;
`;

const Spell = styled.div`
  display: table-cell;
  vertical-align: middle;
  width: 29px;
  padding-left: 5px;
`;

export default function ({ participant, match }) {
  const spell1 = spell.find((e) => {
    if (e.key == participant.summoner1Id) return true;
  });

  const spell2 = spell.find((e) => {
    if (e.key == participant.summoner2Id) return true;
  });

  const perkMain = perks.find((e) => {
    if (e.id == participant.perks.styles[0].style) return true;
  });

  const perkSub = perks.find((e) => {
    if (e.id == participant.perks.styles[1].style) return true;
  });

  const perkInfo = {
    main: perkMain.slots[0].runes.find((e) => {
      if (e.id == participant.perks.styles[0].selections[0].perk) return true;
    }),
    main1: perkMain.slots[1].runes.find((e) => {
      if (e.id == participant.perks.styles[0].selections[1].perk) return true;
    }),
    main2: perkMain.slots[2].runes.find((e) => {
      if (e.id == participant.perks.styles[0].selections[2].perk) return true;
    }),
    main3: perkMain.slots[3].runes.find((e) => {
      if (e.id == participant.perks.styles[0].selections[3].perk) return true;
    }),
  };

  console.log(perkInfo);
  return (
    <ContentWrapper win={participant.win}>
      <MatchStats>
        {getGameType(match.queueId)}
        <br />
        {winOrLose(participant.win)}
      </MatchStats>
      <MatchStats style={{ width: "110px" }}>
        <ChampionImgBig img={getChampImgUrl(participant.championName)}></ChampionImgBig>
        <Spell>
          <SmallImg img={getSpellImgUrl(spell1.id)}></SmallImg>
          <SmallImg img={getSpellImgUrl(spell2.id)}></SmallImg>
        </Spell>
        <Spell>
          <OverlayTrigger
            placement="right"
            overlay={(props) => (
              <Tooltip id="button-tooltip-2" {...props}>
                [{perkInfo.main.name}]<p />
                {perkInfo.main.shortDesc}
              </Tooltip>
            )}
          >
            <SmallImg img={getPerkImgUrl(perkInfo.main.icon)}></SmallImg>
          </OverlayTrigger>
          <OverlayTrigger
            placement="right"
            overlay={(props) => (
              <Tooltip id="button-tooltip-2" {...props}>
                [{perkSub.name}]
              </Tooltip>
            )}
          >
            <SmallImg style={{ width: "16px", height: "16px", margin: "3px" }} img={getPerkImgUrl(perkSub.icon)}></SmallImg>
          </OverlayTrigger>
        </Spell>
        {participant.championName}
      </MatchStats>
      <MatchStats style={{ width: "90px" }}>
        {participant.kills} / {participant.deaths} / {participant.assists}
        <br />
        {getKDA(participant.kills, participant.deaths, participant.assists)}
      </MatchStats>
      <br />
    </ContentWrapper>
  );
}
