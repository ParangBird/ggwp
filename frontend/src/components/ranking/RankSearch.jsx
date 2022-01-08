import {useEffect, useState} from "react";
import axios from 'axios'
import styled from 'styled-components'
import {Link} from "react-router-dom";

export default function RankSearch({changeName}){

    const [summonerName, setSummonerName] = useState('')
    const onChange = (e) => {
        setSummonerName(e.target.value)
        changeName(e.target.value)
    }
    const onSubmit = (e) => {
        setSummonerName(e.target.value)
    }
    return(
        <>
            <h3>소환사 검색</h3>
                <input placeholder="이름" value={summonerName} onChange={onChange}/>
            <Link to={"/ranking/"+summonerName}>
                <button type="button" onClick={onSubmit}>검색</button>
            </Link>
        </>
    )

}