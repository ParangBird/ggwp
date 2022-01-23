import {useState} from "react";
import axios from "axios";

import styled from "styled-components";

const UpdateButton = styled.button`
  background-color : teal;


`;



export default function RankSearch({changeName}){

    const update = () => {
        axios.get('/api/rankinfo').
        then((res) => {
            console.log('랭킹 DB 업데이트 성공')
        }).catch((err) => console.error(err));
    }

    const [summonerName, setSummonerName] = useState('')
    const onChange = (e) => {
        setSummonerName(e.target.value)
        changeName(e.target.value)
    }
    return(
        <>
            <UpdateButton onClick = {update}>랭킹 업데이트</UpdateButton>
            <h3>소환사 검색</h3>
                <input placeholder="이름" value={summonerName} onChange={onChange}/>
        </>
    )

}