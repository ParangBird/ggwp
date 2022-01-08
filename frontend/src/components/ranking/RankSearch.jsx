import {useState} from "react";

export default function RankSearch({changeName}){

    const [summonerName, setSummonerName] = useState('')
    const onChange = (e) => {
        setSummonerName(e.target.value)
        changeName(e.target.value)
    }
    return(
        <>
            <h3>소환사 검색</h3>
                <input placeholder="이름" value={summonerName} onChange={onChange}/>
        </>
    )

}