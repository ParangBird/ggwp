import {useEffect, useState} from "react";
import axios from 'axios'

export default function RankTable() {

    const [rankInfo, setRankInfo] = useState([])
    const [startRank, setStartRank] = useState(1)
    useEffect(
        () => {
            axios.get('http://localhost:8080/api/rank/' + startRank)
                .then(res => {
                    setRankInfo(res.data);
                }).catch((err) => {
                console.log('에러')
            })
        }
    , [rankInfo])


    const goPrev = () => {
        console.log('go prev')
        if(startRank >= 51)
            setStartRank(startRank-50)
    }

    const goNext = () => {
        console.log('go next')
        setStartRank(startRank+50);
    }

    return (
        <div>
            {rankInfo.map((rank, index) => (
                <div>
                    <span key={rank.summonerId}>
                      {rank.summonerName}
                    </span>
                    <br/>
                </div>
            ))}

            <button onClick={goPrev}>이전</button> <button onClick={goNext}>다음</button>
        </div>
    )
}