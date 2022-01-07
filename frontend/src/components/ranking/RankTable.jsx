import {useEffect, useState} from "react";
import axios from 'axios'

export default function RankTable() {

    const [rankInfo, setRankInfo] = useState([])
    const [startRank, setStartRank] = useState(1)
    useEffect(
        () => {
            axios.get('/api/rank/' + startRank)
                .then(res => {
                    setRankInfo(res.data);
                }).catch((err) => {
                    console.error(err)
                    console.log('에러')
            })
        }
    , [rankInfo])


    const goPrev = () => {
        //console.log('go prev')
        if(startRank >= 51)
            setStartRank(startRank-50)
    }

    const goNext = () => {
        //console.log('go next')
        setStartRank(startRank+50);
    }

    return (

        <>
            <table style={{margin : '0 auto', border : '1px solid black'}}>
                <thead>
                    <tr style={{border : '1px solid black'}}>
                        <th >순위</th>
                        <th>소환사명</th>
                        <th>티어</th>
                        <th>LP</th>
                        <th>승률</th>
                    </tr>
                </thead>
                <tbody>
                {
                    rankInfo.map((rank, index) => (
                    <tr style={{border : '1px solid black'}} key={rank.summonerId}>
                        <td>{index+1}</td>
                        <td>{rank.summonerName}</td>
                        <td>{rank.summonerRank}</td>
                        <td>{rank.leaguePoints}LP</td>
                        <td>{rank.wins}승 {rank.losses}패</td>
                    </tr>
                ))
                }
                </tbody>
            </table>
            <button onClick={goPrev}>이전</button> <button onClick={goNext}>다음</button>
        </>
    )

}