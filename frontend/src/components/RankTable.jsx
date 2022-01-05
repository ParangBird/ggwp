import {useEffect, useState} from "react";
import axios from 'axios'

export default function RankTable() {

    const [rankInfo, setRankInfo] = useState([])
    //id, summonerId, summonerName, leaguePoints, summmonerRank, wins, losses, veteran, inactive, freshBlood, hotStreak

    useEffect(
        () => {
            axios.get('http://localhost:8080/api/rank/1')
                .then(res => {
                    setRankInfo(res.data);
                }).catch((err) => {
                console.log('에러')
            })
        }
    , [])

    return (
        <div>
            {rankInfo.map((rank, index) => (
                <div>
                    <span key={index}>
                      {rank.summonerName}
                    </span>
                    <br/>
                </div>
            ))}
        </div>
    )
}