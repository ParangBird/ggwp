import {useEffect, useState} from "react";
import axios from 'axios'
import {Link, useLocation, useParams} from "react-router-dom";
import {Button} from "react-bootstrap";

const tableStyle = {
    borderCollapse : 'separate',
    borderSpacing : '1px',
    textAlign : 'center',
    lineHeight : '1.5',
    margin : '0 auto',
    width: '50%',
    padding : '50px 0 50px 0'
}
const thStyle = {
    width: '155px',
    padding: '10px',
    fontWeight: 'bold',
    verticalAlign: 'top',
    color: '#fff',
    background: '#ce4869'
}
const tdStyle = {
    width: '155px',
    padding: '10px',
    verticalAlign: 'top',
    borderBottom: '1px solid #ccc',
    background: '#efefef'
}

export default function RankTable({name, changeName}) {
    const [rankInfo, setRankInfo] = useState([])
    const [startRank, setStartRank] = useState(1)
    const [searchSummonerName, setSearchSummonerName] = useState(useParams().summonerName)

    useEffect(
        () => {
            if(searchSummonerName) {
                console.log('되는중' + searchSummonerName)
                axios.get('/api/rankBySummonerName/' + searchSummonerName)
                    .then(res => {
                        setRankInfo(res.data);
                    }).catch((err) => {
                    console.error(err)
                    console.log('에러')
                })
            }
            else{
                setStartRank(1)
                console.log('기본 되는중')
                axios.get('/api/rank/' + startRank)
                    .then(res => {
                        setRankInfo(res.data);
                    }).catch((err) => {
                    console.error(err)
                    console.log('에러')
                })
            }

        }
    , [searchSummonerName])

    const re = () => {
        setSearchSummonerName(name)
        changeName(searchSummonerName)

    }

    const goPrev = () => {
        if(startRank >= 51)
            setStartRank(startRank-50)
        else
            setStartRank(1)
    }

    const goNext = () => {
        setStartRank(startRank+50);
    }
    return (
        <>
            <h2>name is : {name}</h2>
            <Button onClick={re}>ssss</Button>
            <table style={tableStyle}>
                <thead>
                    <tr style={{border : '1px solid black'}}>
                        <th style={thStyle}>순위</th>
                        <th style={thStyle}>소환사명</th>
                        <th style={thStyle}>티어</th>
                        <th style={thStyle}>LP</th>
                        <th style={thStyle}>승률</th>
                    </tr>
                </thead>
                <tbody>
                {
                    rankInfo.map((rank, index) => (
                    <tr style={{border : '1px solid black'}} key={rank.summonerId}>
                        <td style={tdStyle}>{index+1}</td>
                        <td style={tdStyle}><a target="_blank" href={"/search/"+rank.summonerName}>{rank.summonerName}</a></td>
                        <td style={tdStyle}>{rank.summonerRank}</td>
                        <td style={tdStyle}>{rank.leaguePoints}LP</td>
                        <td style={tdStyle}>{rank.wins}승 {rank.losses}패</td>
                    </tr>
                ))
                }
                </tbody>
            </table>
            <button onClick={goPrev}>이전</button> <button onClick={goNext}>다음</button>
        </>
    )

}