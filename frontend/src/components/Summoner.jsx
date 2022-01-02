import axios from "axios";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react/cjs/react.development";

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
    <div>
      <div>{name}</div>
      <img src={summoner.profileIconUrl}></img>
      <div>{summoner.summonerLevel}</div>
    </div>
  );
}
