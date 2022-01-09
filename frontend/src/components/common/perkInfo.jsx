export const perkInfo = [
  {
    id: 8100,
    name: "지배",
    iconPath: "perk-images/Styles/7200_Domination.png",
  },
  {
    id: 8300,
    name: "영감",
    iconPath: "perk-images/Styles/7203_Whimsy.png",
  },
  {
    id: 8000,
    name: "정밀",
    iconPath: "perk-images/Styles/7201_Precision.png",
  },
  {
    id: 8400,
    name: "결의",
    iconPath: "perk-images/Styles/7204_Resolve.png",
  },
  {
    id: 8200,
    name: "마법",
    iconPath: "perk-images/Styles/7202_Sorcery.png",
  },
  {
    id: 8369,
    name: "선제공격",
    majorChangePatchVersion: "11.23",
    tooltip:
      "적 챔피언과 전투 시작 후 @GraceWindow.2@초 내에 스킬이나 기본 공격으로 해당 적 챔피언에게 피해를 입히면 @GoldProcBonus@골드를 획득하고 @Duration@초 동안 <b>선제공격</b> 효과가 발동됩니다. 효과 발동 시 적 챔피언에게 <truedamage>@DamageAmp*100@%</truedamage>의 추가 <truedamage>피해</truedamage>를 입힙니다. 또한 입힌 추가 피해의 <gold>{{ Item_Melee_Ranged_Split }}</gold>만큼 <gold>골드</gold>를 획득합니다.<br><br>재사용 대기시간: <scaleLevel>@Cooldown@</scaleLevel><br><hr><br>적에게 입힌 피해량: @f1@<br>획득한 골드: @f2@",
    shortDesc: "적 챔피언과 전투 개시 시 3초 동안 10%의 추가 피해 및 입힌 피해에 따라 골드 획득",
    longDesc:
      "적 챔피언과 전투 시작 후 0.25초 내에 스킬이나 기본 공격으로 해당 적 챔피언에게 피해를 입히면 5골드를 획득하고 3초 동안 <b>선제공격</b> 효과가 발동됩니다. 효과 발동 시 적 챔피언에게 <truedamage>10%</truedamage>의 추가 <truedamage>피해</truedamage>를 입힙니다. 또한 입힌 추가 피해의 <gold>100%(원거리 챔피언은 70%)</gold>에 해당하는 <gold>골드</gold>를 획득합니다.<br><br>재사용 대기시간: <scaleLevel>25~15</scaleLevel>",
    iconPath: "perk-images/Styles/Inspiration/FirstStrike/FirstStrike.png",
    endOfGameStatDescs: ["적에게 입힌 피해량: @eogvar1@", "획득한 골드: @eogvar2@"],
  },
  {
    id: 8446,
    name: "철거",
    majorChangePatchVersion: "",
    tooltip:
      "포탑으로부터 600 범위 안에 있을 경우 3초에 걸쳐 포탑에 대한 강력한 공격을 충전합니다. 충전된 공격은 <scaleAD>@f6@</scaleAD>의 추가 물리 피해를 입힙니다. <br><hr><br>남은 재사용 대기시간: @f2@<br>총 추가 피해량: <scaleAD>@f1@</scaleAD><br>현재 피해량: 100+최대 체력의 35%",
    shortDesc: "포탑 근처에서 포탑에 대한 강력한 공격을 충전",
    longDesc:
      "포탑으로부터 600 범위 안에 있을 경우 3초에 걸쳐 포탑에 대한 강력한 공격을 충전합니다. 충전된 공격은 100(+최대 체력의 35%)에 해당하는 추가 물리 피해를 입힙니다. <br><br>재사용 대기시간: 45초",
    iconPath: "perk-images/Styles/Resolve/Demolish/Demolish.png",
    endOfGameStatDescs: ["총 추가 피해량: @eogvar1@"],
  },
  {
    id: 8126,
    name: "비열한 한 방",
    majorChangePatchVersion: "9.9",
    tooltip:
      "<b>이동 또는 행동을 방해받은</b> 상태의 챔피언에게 피해를 주면 레벨에 따라 10 ~ 45의 추가 고정 피해를 입힙니다.<br><br>재사용 대기시간: 4초<br><rules>방해 효과 이후 피해를 가할 때 활성화됩니다.</rules><br><hr><br>현재 피해량: @f2@<br>적에게 가한 총 추가 피해량: @f1@",
    shortDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_ImpairAct'>이동 또는 행동이 제약된</lol-uikit-tooltipped-keyword> 적 챔피언에게 추가 고정 피해 ",
    longDesc:
      "<b>이동 또는 행동을 방해받은</b> 상태의 챔피언에게 피해를 주면 레벨에 따라 10 ~ 45의 추가 고정 피해를 입힙니다.<br><br>재사용 대기시간: 4초<br><rules>방해 효과 이후 피해를 가할 때 활성화됩니다.</rules>",
    iconPath: "perk-images/Styles/Domination/CheapShot/CheapShot.png",
    endOfGameStatDescs: ["총 피해량: @eogvar1@"],
  },
  {
    id: 8321,
    name: "외상",
    majorChangePatchVersion: "",
    tooltip: "외상으로 아이템을 구입할 수 있습니다. 외상 한도는 점차 증가합니다.<br><br>외상 비용: 50골드<br><hr><br>외상 한도: 2분 부터 사용 가능<br>외상 구매: @f3@",
    shortDesc: "아이템 외상 구매 가능",
    longDesc: "외상으로 아이템을 구입할 수 있습니다. 외상 한도는 점차 증가합니다.<br><br>외상 비용: 50골드<br>외상 한도: 150 + 분당 5<br>(외상은 2분부터 사용 가능합니다.)",
    iconPath: "perk-images/Styles/Inspiration/FuturesMarket/FuturesMarket.png",
    endOfGameStatDescs: ["외상 구매: @eogvar1@"],
  },
  {
    id: 8415,
    name: "신비로운 거석상",
    majorChangePatchVersion: "",
    tooltip:
      "<pathResolve>결의</pathResolve> + <pathSorcery>마법</pathSorcery> <br>체력 +0 ~ 0 (레벨에 비례)<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathResolve>결의</pathResolve> + <pathSorcery>마법</pathSorcery> 세트 보너스</pathBonus>",
    longDesc:
      "체력 +0 ~ 0 (레벨에 비례)<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8410,
    name: "쾌속 접근",
    majorChangePatchVersion: "",
    tooltip:
      "이동 방해 스킬에 맞은 근처의 적 챔피언에게 이동할 때 <speed>이동 속도가 7.5%</speed> 증가합니다. 적 챔피언에게 이동 방해 스킬을 맞히고 해당 적에게 이동할 때는 <speed>이동 속도가 15%</speed>까지 증가합니다. <br><br>아군 군중 제어 사용 범위: 1000<br><hr><br>이동 속도 증가 시간: @f1@초",
    shortDesc:
      "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_ImpairMov'>이동을 방해받은</lol-uikit-tooltipped-keyword> 근처 적 챔피언에게 이동할 때 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_MS'>이동 속도</lol-uikit-tooltipped-keyword> 증가. 자신이 이동 방해 스킬을 맞힌 적에게 이동할 때는 추가 증가",
    longDesc:
      "이동 방해 스킬에 맞은 근처의 적 챔피언에게 이동할 때 <speed>이동 속도가 7.5%</speed> 증가합니다. 적 챔피언에게 이동 방해 스킬을 맞히고 해당 적에게 이동할 때는 <speed>이동 속도가 15%</speed>까지 증가합니다. <br><br>아군 군중 제어 사용 범위: 1000",
    iconPath: "perk-images/Styles/Resolve/ApproachVelocity/ApproachVelocity.png",
    endOfGameStatDescs: ["이동 속도 증가 시간: @eogvar1@"],
  },
  {
    id: 8135,
    name: "굶주린 사냥꾼",
    majorChangePatchVersion: "",
    tooltip:
      "<lifeSteal>모든 피해 흡혈</lifeSteal>: <i>현상금 사냥꾼</i> 중첩 1회당 1.2% <br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.<br><br><rules>광역 피해를 입히거나 소환물을 통해 피해를 입힐 때는 모든 피해 흡혈이 33%로 감소합니다.</rules><br><br>총 회복량: @f3@<br><br><u>획득할 수 없는 현상금</u>",
    shortDesc:
      "적 챔피언당 <b>1회</b> 한정 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 <lifesteal>모든 피해 흡혈</lifesteal> 영구 획득 ",
    longDesc:
      "<lifeSteal>모든 피해 흡혈</lifeSteal>: <i>현상금 사냥꾼</i> 중첩 1회당 1.2% <br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.<br><br><rules>광역 피해를 입히거나 소환물을 통해 피해를 입힐 때는 모든 피해 흡혈이 33%로 감소합니다.</rules>",
    iconPath: "perk-images/Styles/Domination/RavenousHunter/RavenousHunter.png",
    endOfGameStatDescs: ["총 회복량: @eogvar1@", "총 중첩 수: @eogvar2@"],
  },
  {
    id: 8232,
    name: "물 위를 걷는 자",
    majorChangePatchVersion: "",
    tooltip:
      "강에 있을 때 <speed>이동 속도가 25</speed> 증가하고 레벨에 비례하여 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 최대 18 또는 추가 주문력 최대 30의 효과를 얻습니다.",
    shortDesc:
      "강에 있을 때 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_MS'>이동 속도</lol-uikit-tooltipped-keyword>를 얻고 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'>적응형</lol-uikit-tooltipped-keyword>으로 주문력 또는 공격력 증가",
    longDesc:
      "강에 있을 때 <speed>이동 속도가 25</speed> 증가하고 레벨에 비례하여 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 최대 18 또는 추가 주문력 최대 30의 효과를 얻습니다.<br><br><hr><br><i>굽이치는 강물처럼 빠르고 깜짝 놀란 협곡 바위 게처럼 날렵하게 움직이리라.</i><br>",
    iconPath: "perk-images/Styles/Sorcery/Waterwalking/Waterwalking.png",
    endOfGameStatDescs: ["총 활성화 시간: @eogvar1@:@eogvar2@"],
  },
  {
    id: 8299,
    name: "최후의 저항",
    majorChangePatchVersion: "",
    tooltip:
      "체력이 60% 이하일 때 적 챔피언 공격 시 5% ~ 11%의 추가 피해를 줍니다. 체력이 30%일 때 최대 피해량에 도달합니다.<br><br><rules>최소 5%의 추가 피해를 입힙니다.<br>체력이 30% 아래로 내려가면 추가 피해량이 최대치까지 증가합니다.</rules><br><hr><br>총 추가 피해량: <scaleAD>@f1@</scaleAD>",
    shortDesc: "체력이 낮을 때 적 챔피언 공격 시 추가 피해",
    longDesc: "체력이 60% 이하일 때 적 챔피언 공격 시 5% ~ 11%의 추가 피해를 줍니다. 체력이 30%일 때 최대 피해량에 도달합니다.",
    iconPath: "perk-images/Styles/Sorcery/LastStand/LastStand.png",
    endOfGameStatDescs: ["총 추가 피해량: @eogvar1@"],
  },
  {
    id: 8112,
    name: "감전",
    majorChangePatchVersion: "",
    tooltip:
      "3초 동안 같은 챔피언에게 <b>개별</b> 공격 또는 스킬을 3회 적중시키면 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'><font color='#48C4B7'>적응형 피해</font></lol-uikit-tooltipped-keyword>를 입힙니다.<br>재사용 대기시간: 25 ~ 20초<br><hr><br>현재 피해량: @f2@ (<scaleAP>+@f3@</scaleAP>) (<scaleAD>+@f4@</scaleAD>)<br>적에게 가한 총 피해량: <scaleAD>@f1@</scaleAD>",
    shortDesc:
      "3초 동안 같은 챔피언에게 기본 공격 또는 <b>개별</b> 스킬 3회를 적중시키면 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'>적응형 피해</lol-uikit-tooltipped-keyword> 적용",
    longDesc:
      "3초 동안 같은 챔피언에게 <b>개별</b> 공격 또는 스킬을 3회 적중시키면 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'><font color='#48C4B7'>적응형 피해</font></lol-uikit-tooltipped-keyword>를 입힙니다.<br><br>피해량: 30~180 (+추가 공격력의 0.4, +주문력의 0.25)<br><br>재사용 대기시간: 25~20초<br><br><hr><i>'우리는 그들을 천둥군주라고 부른다. 그들의 번개를 입에 올리는 것은 재앙을 부르는 길이기 때문이다.'</i>",
    iconPath: "perk-images/Styles/Domination/Electrocute/Electrocute.png",
    endOfGameStatDescs: ["적에게 입힌 총 피해량: @eogvar1@"],
  },
  {
    id: 8234,
    name: "기민함",
    majorChangePatchVersion: "9.9",
    tooltip: "모든 추가 이동 속도 효과가 7% 증가하고 <speed>이동 속도를 1%</speed> 추가로 얻습니다.<br><br>현재 획득한 효과: <speed>이동 속도 @f1@</speed><br>추가 이동 거리: @f2@",
    shortDesc: "모든 추가 <speed>이동 속도</speed> 효과가 7% 증가하고 <speed>이동 속도 1%</speed> 증가",
    longDesc: "모든 추가 이동 속도 효과가 7% 증가하고 <speed>이동 속도를 1%</speed> 추가로 얻습니다.",
    iconPath: "perk-images/Styles/Sorcery/Celerity/CelerityTemp.png",
    endOfGameStatDescs: ["추가 이동 거리: @eogvar1@"],
  },
  {
    id: 8453,
    name: "소생",
    majorChangePatchVersion: "",
    tooltip:
      "보호막 및 체력 회복 효과가 5% 증가합니다.<br><br>체력이 40% 이하인 대상에게는 자신이 사용하거나 받는 회복과 보호막 효과가 10% 강화됩니다.<br><hr><br><scaleAD>추가 체력 회복량</scaleAD>: @f1@<br><scaleAD>추가 보호막</scaleAD>: @f2@<br><scaleAD>총 체력 회복 및 보호막</scaleAD>: @f4@%",
    shortDesc: "보호막 및 체력 회복 5% 증가<br><br>체력이 40% 이하인 대상에게는 자신이 사용하거나 받는 회복과 보호막 효과가 10% 강화",
    longDesc: "보호막 및 체력 회복 효과가 5% 증가합니다.<br><br>체력이 40% 이하인 대상에게는 자신이 사용하거나 받는 회복과 보호막 효과가 10% 강화됩니다.",
    iconPath: "perk-images/Styles/Resolve/Revitalize/Revitalize.png",
    endOfGameStatDescs: ["추가 회복량: @eogvar1@", "추가 보호막 흡수량: @eogvar2@"],
  },
  {
    id: 8360,
    name: "봉인 풀린 주문서",
    majorChangePatchVersion: "8.9",
    tooltip:
      "장착한 소환사 주문을 한 번만 사용 가능한 새로운 소환사 주문으로 교환합니다. 이전에 쓰지 않은 새로운 소환사 주문으로 교환할 때마다 교환의 재사용 대기시간이 영구적으로 25초씩 감소합니다. (최초 교환의 재사용 대기시간: 5분) <br><br>첫 번째 교환은 6분부터 가능합니다. <br><rules><br>소환사 주문은 전투에서 벗어났을 때만 교환할 수 있습니다. <br>교환한 소환사 주문을 사용한 후 3번 더 교환해야 다시 첫 번째 소환사 주문을 선택할 수 있습니다.<br>소환사 주문을 2회 교환한 후부터 강타 피해량이 증가합니다. </rules><hr><br>사용한 소환사 주문 종류: @f4@/@f8@<br>현재 교환 재사용 대기시간: @f3@초",
    shortDesc: "전투에서 벗어났을 때 소환사 주문 교환 가능. 새로운 소환사 주문으로 교환할 때마다 교환 재사용 대기시간 감소.",
    longDesc:
      "장착한 소환사 주문을 한 번만 사용 가능한 새로운 소환사 주문으로 교환합니다. 이전에 쓰지 않은 새로운 소환사 주문으로 교환할 때마다 교환의 재사용 대기시간이 영구적으로 25초씩 감소합니다. (최초 교환의 재사용 대기시간: 5분) <br><br>첫 번째 교환은 6분부터 가능합니다. <br><rules><br>소환사 주문은 전투에서 벗어났을 때만 교환할 수 있습니다. <br>교환한 소환사 주문을 사용한 후 3번 더 교환해야 다시 첫 번째 소환사 주문을 선택할 수 있습니다.<br>소환사 주문을 2회 교환한 후부터 강타 피해량이 증가합니다. </rules>",
    iconPath: "perk-images/Styles/Inspiration/UnsealedSpellbook/UnsealedSpellbook.png",
    endOfGameStatDescs: ["교환된 소환사 주문: @eogvar1@"],
  },
  {
    id: 8004,
    name: "완전무결",
    majorChangePatchVersion: "",
    tooltip:
      "<pathPrecision>정밀</pathPrecision> + <pathSorcery>마법</pathSorcery><br>공격 속도 +0%<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathPrecision>정밀</pathPrecision> + <pathSorcery>마법</pathSorcery> 세트 보너스</pathBonus>",
    longDesc: "공격 속도 +0%<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8128,
    name: "어둠의 수확",
    majorChangePatchVersion: "8.23",
    tooltip:
      "체력이 50%보다 낮은 챔피언에게 피해를 입히면 <scaleAD>@f8@의 물리 피해</scaleAD>의 적응형 피해를 추가로 입히고 해당 챔피언의 영혼을 수확해 어둠의 수확 효과의 피해량이 영구적으로 <font color='#fc314e'>@f12@</font>만큼 증가합니다.<br><br>재사용 대기시간: 45초 (처치 관여 시 1.5초로 초기화)<br><hr><br>수확한 영혼: <font color='#fc314e'>@f5@</font><br>현재 피해량: <scaleLevel>@f7@</scaleLevel><font color='#fc314e'>(+@f6@)</font><scaleAD>(+@f10@)</scaleAD><scaleAP>(+@f11@)</scaleAP> <br>적에게 입힌 총 피해량: @f9@",
    shortDesc:
      "체력이 낮은 챔피언에게 피해를 입히면 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'>적응형 피해</lol-uikit-tooltipped-keyword>를 입히고 해당 챔피언의 영혼을 수확",
    longDesc:
      "체력이 50%보다 낮은 챔피언에게 피해를 입히면 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'>적응형 피해</lol-uikit-tooltipped-keyword>를 추가로 입히고 해당 챔피언의 영혼을 수확해 어둠의 수확 효과의 피해량이 영구적으로 5만큼 증가합니다.<br><br>어둠의 수확 피해량: 20~60 (레벨에 비례) (+영혼당 피해량 5) (+추가 공격력의 0.25) (+주문력의 0.15)<br>재사용 대기시간: 45초 (처치 관여 시 1.5초로 초기화)",
    iconPath: "perk-images/Styles/Domination/DarkHarvest/DarkHarvest.png",
    endOfGameStatDescs: ["적에게 입힌 총 피해량: @eogvar1@", "수확한 영혼: 총 @eogvar2@개"],
  },
  {
    id: 8220,
    name: "대재앙",
    majorChangePatchVersion: "",
    tooltip:
      "<pathSorcery>마법</pathSorcery> + <pathDomination>지배</pathDomination><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathSorcery>마법</pathSorcery> + <pathDomination>지배</pathDomination> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8016,
    name: "무자비한 정예병",
    majorChangePatchVersion: "",
    tooltip:
      "<pathPrecision>정밀</pathPrecision> + <pathDomination>지배</pathDomination><br>공격 속도 +0%<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathPrecision>정밀</pathPrecision> + <pathDomination>지배</pathDomination> 세트 보너스</pathBonus>",
    longDesc: "공격 속도 +0%<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8473,
    name: "뼈 방패",
    majorChangePatchVersion: "9.9",
    tooltip:
      "적 챔피언으로부터 피해를 입은 뒤 적이 가하는 3회의 스킬 및 기본 공격으로부터 <scaleLevel>@f2@</scaleLevel>만큼 피해를 덜 받습니다.<br><br>지속시간: 1.5초<br>재사용 대기시간: 45초<br><hr><br>감소한 피해량: 총 <scaleLevel>@f1@</scaleLevel>",
    shortDesc: "적 챔피언으로부터 피해를 입은 뒤 해당 적이 가하는 3회의 스킬 및 기본 공격으로부터 30~60만큼 피해를 덜 받습니다.<br><br><br>지속시간: 1.5초<br>재사용 대기시간: 45초",
    longDesc: "적 챔피언으로부터 피해를 입은 뒤 해당 적이 가하는 3회의 스킬 및 기본 공격으로부터 30~60만큼 피해를 덜 받습니다.<br><br><br>지속시간: 1.5초<br>재사용 대기시간: 45초",
    iconPath: "perk-images/Styles/Resolve/BonePlating/BonePlating.png",
    endOfGameStatDescs: ["흡수한 총 피해량: @eogvar1@"],
  },
  {
    id: 8339,
    name: "천상의 신체",
    majorChangePatchVersion: "",
    tooltip: "영구적으로 체력이 100 증가합니다.<br>게임 시작 후 10분까지 챔피언 및 몬스터에게 주는 피해량이 10% 감소합니다.",
    shortDesc: "체력 +100 영구 증가<br>게임 시작 후 10분까지 챔피언 및 몬스터에게 주는 피해량 10% 감소",
    longDesc: "체력 +100 영구 증가<br>게임 시작 후 10분까지 챔피언 및 몬스터 대상 피해량 10% 감소<br><br><hr><br><i>'가장 위대한 전설은 영원히 별 안에 살아남는다.' <br>—꿈꾸는 자, 다프나</i>",
    iconPath: "perk-images/Styles/Inspiration/CelestialBody/CelestialBody.png",
    endOfGameStatDescs: ["--"],
  },
  {
    id: 8214,
    name: "콩콩이 소환",
    majorChangePatchVersion: "",
    tooltip:
      "적 챔피언을 기본 공격 또는 스킬로 공격하면 콩콩이를 보내 <font color='#FFFFFF'>@f5@</font>(+<scaleAP>@f6@</scaleAP>)(+<scaleAD>@f7@</scaleAD>)만큼 피해를 입힙니다.<br><br>아군에게 스킬로 강화 효과 또는 보호막을 적용하면 콩콩이를 보내 <font color='#FFFFFF'>@f8@</font>(+<scaleAP>@f9@</scaleAP>)(+<scaleAD>@f10@</scaleAD>)만큼 피해를 흡수하는 보호막을 씌웁니다.<br><br>콩콩이는 자신에게 돌아오기 전까지 다른 대상에게 보낼 수 없습니다.<br><br><hr><br>콩콩이가 적을 <font color='#FFFFFF'>@f1@</font>회 공격하고 총 <font color='#FFFFFF'>@f3@</font>의 피해를 입혔습니다.<br>콩콩이가 아군을 <font color='#FFFFFF'>@f2@</font>회 도와 총 <font color='#FFFFFF'>@f4@</font>의 피해를 막아주었습니다.",
    shortDesc: "공격 또는 스킬 사용 시 대상에 콩콩이를 보내 적에게 피해를 주거나 아군에게 보호막 생성",
    longDesc:
      "적 챔피언을 기본 공격 또는 스킬로 공격하면 콩콩이를 보내 레벨에 따라 10~40(+<scaleAP>주문력의 0.1</scaleAP>)(+<scaleAD>추가 공격력의 0.15</scaleAD>)만큼 피해를 입힙니다.<br><br>아군에게 스킬로 강화 효과 또는 보호막을 적용하면 콩콩이를 보내 레벨에 따라 35~80(+<scaleAP>주문력의 0.25</scaleAP>)(+<scaleAD>추가 공격력의 0.4</scaleAD>)만큼 피해를 흡수하는 보호막을 씌웁니다.<br><br>콩콩이는 자신에게 돌아오기 전까지 다른 대상에게 보낼 수 없습니다.",
    iconPath: "perk-images/Styles/Sorcery/SummonAery/SummonAery.png",
    endOfGameStatDescs: ["적에게 입힌 피해량: @eogvar1@", "보호막으로 흡수한 피해량: @eogvar2@"],
  },
  {
    id: 8237,
    name: "주문 작열",
    majorChangePatchVersion: "9.9",
    tooltip: "다음 공격 스킬 적중 시 챔피언에게 불을 붙여 1초 후 레벨에 따라 15~35의 추가 마법 피해를 줍니다.<br><br>재사용 대기시간: 10초<br><hr><br>현재 피해량: @f2@<br>적에게 입힌 총 피해량: @f1@",
    shortDesc: "10초마다 공격 스킬 적중 시 챔피언을 불태움",
    longDesc: "다음 공격 스킬 적중 시 챔피언에게 불을 붙여 1초 후 레벨에 따라 15~35의 추가 마법 피해를 줍니다.<br><br>재사용 대기시간: 10초",
    iconPath: "perk-images/Styles/Sorcery/Scorch/Scorch.png",
    endOfGameStatDescs: ["총 추가 피해량: @eogvar1@"],
  },
  {
    id: 8139,
    name: "피의 맛",
    majorChangePatchVersion: "",
    tooltip:
      "적 챔피언에게 피해를 입히면 체력을 회복합니다.<br><br>회복량: <font color='#ffffff'>@f2@</font> (+<scaleAD>@f3@</scaleAD>) (+<scaleAP>@f4@</scaleAP>)<br><br>재사용 대기시간: 20초<br><hr><br>총 회복량: @f1@",
    shortDesc: "적 챔피언에게 피해를 입히면 체력을 회복합니다.",
    longDesc: "적 챔피언에게 피해를 입히면 체력을 회복합니다.<br><br>회복량: 18 ~ 35 (+추가 공격력의 0.2, +주문력의 0.1) (레벨에 비례)<br><br>재사용 대기시간: 20초",
    iconPath: "perk-images/Styles/Domination/TasteOfBlood/GreenTerror_TasteOfBlood.png",
    endOfGameStatDescs: ["총 회복량: @eogvar1@"],
  },
  {
    id: 8008,
    name: "치명적 속도",
    majorChangePatchVersion: "",
    tooltip:
      "적 챔피언을 기본 공격하면 6초 동안 공격 속도가 %i:scaleAS% (%i:meleeActive% 13% || %i:rangedActive% 7%) 상승합니다. 이 효과는 중첩되어 공격 속도가 최대 %i:scaleAS%(%i:meleeActive% 78% || %i:rangedActive% 42%)까지 상승합니다.<br><br>최대로 중첩되면 공격 속도가 2.5를 초과할 수 있으며 공격 사거리가 (%i:meleeActive% 50 || %i:rangedActive% 75) 상승합니다.<br><hr><br>지속시간: @f1@초",
    shortDesc: "적 챔피언 기본 공격 시 공격 속도 상승. (최대 6회 중첩) 최대 중첩 시 공격 사거리 상승 및 최고 공격 속도 제한 해제",
    longDesc:
      "적 챔피언을 기본 공격하면 6초 동안 공격 속도가 13% (근접) 또는 7% (원거리) 상승합니다. 이 효과는 78% (근접) 또는 42%(원거리)까지 중첩됩니다.<br><br>최대로 중첩되면 공격 속도가 2.5를 초과할 수 있으며 공격 사거리가 50 (근접) 또는 75 (원거리) 상승합니다.",
    iconPath: "perk-images/Styles/Precision/LethalTempo/LethalTempoTemp.png",
    endOfGameStatDescs: ["최대 공격 속도 지속시간: @eogvar1@:@eogvar2@"],
  },
  {
    id: 9105,
    name: "전설: 강인함",
    majorChangePatchVersion: "",
    tooltip:
      "강인함이 5% 증가하며 <i>전설</i> 중첩당 2.5%의 강인함이 추가로 증가합니다. (<statGood>최대 전설 중첩 횟수: 10</statGood>)<br><br>챔피언 처치 관여, 에픽 몬스터 처치 관여, 대형 몬스터 처치, 미니언 처치 시마다 <i>전설</i> 중첩을 얻습니다.<br><hr><br>강인함 증가: 총 <scaleAD>@f1*100@%</scaleAD> (<statGood>최대 10중첩 중 @f3@ 획득</statGood>)<br>다음 중첩까지 진행률: @f2@%",
    shortDesc: "적 챔피언 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 영구적으로 <b>강인함</b> 효과 획득 ",
    longDesc:
      "강인함이 5% 증가하며 <i>전설</i> 중첩당 2.5%의 강인함이 추가로 증가합니다. (<statGood>최대 전설 중첩 횟수: 10</statGood>)<br><br>챔피언 처치 관여, 에픽 몬스터 처치 관여, 대형 몬스터 처치, 미니언 처치 시마다 <i>전설</i> 중첩을 얻습니다.",
    iconPath: "perk-images/Styles/Precision/LegendTenacity/LegendTenacity.png",
    endOfGameStatDescs: ["완료 시간: @eogvar1@:@eogvar2@"],
  },
  {
    id: 8010,
    name: "정복자",
    majorChangePatchVersion: "9.4",
    tooltip:
      "적 챔피언에게 기본 공격 또는 스킬로 피해를 입히면 5초 동안 정복자 중첩을 2만큼 얻어 중첩마다 <scaleAD>공격력</scaleAD> <scaleLevel>@f5.1@</scaleLevel> 효과를 얻습니다. 최대 12회까지 중첩됩니다. 원거리 챔피언은 기본 공격으로 중첩을 1만 획득할 수 있습니다.<br><br>최대로 중첩되면 챔피언에게 입힌 피해량의 9%만큼 체력을 회복합니다. (원거리 챔피언은 6%)<br><br>총 회복량: @f1@",
    shortDesc: "적 챔피언 공격 시 적응형 능력치 중첩 획득. 12회 중첩 시 챔피언 대상 피해량의 일부만큼 체력 회복",
    longDesc:
      "적 챔피언에게 기본 공격 또는 스킬로 피해를 입히면 5초 동안 정복자 중첩을 2만큼 얻어 중첩마다 2~4.5의 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형 능력치</font></lol-uikit-tooltipped-keyword>를 얻습니다. 최대 12회까지 중첩됩니다. 원거리 챔피언은 기본 공격으로 중첩을 1만 획득할 수 있습니다.<br><br>최대로 중첩되면 챔피언에게 입힌 피해량의 9%만큼 체력을 회복합니다. (원거리 챔피언은 6%)",
    iconPath: "perk-images/Styles/Precision/Conqueror/Conqueror.png",
    endOfGameStatDescs: ["총 회복량: @eogvar1@"],
  },
  {
    id: 8106,
    name: "궁극의 사냥꾼",
    majorChangePatchVersion: "9.9",
    tooltip:
      "궁극기의 스킬 가속이 <attention>6</attention>+<i>현상금 사냥꾼</i> 중첩 1회당 <attention>5</attention> 증가합니다.<br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.<br><hr><br><u>획득할 수 없는 현상금</u>",
    shortDesc: "적 챔피언당 <b>1회</b> 한정 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 궁극기 재사용 대기시간 영구 감소 ",
    longDesc:
      "궁극기의 스킬 가속이 <attention>6</attention>+<i>현상금 사냥꾼</i> 중첩 1회당 <attention>5</attention> 증가합니다.<br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.",
    iconPath: "perk-images/Styles/Domination/UltimateHunter/UltimateHunter.png",
    endOfGameStatDescs: ["총 중첩 수: @eogvar1@"],
  },
  {
    id: 8017,
    name: "체력차 극복",
    majorChangePatchVersion: "",
    tooltip:
      "적 챔피언의 최대 체력이 자신보다 많은 정도에 비례해 해당 챔피언에게 5%~15%의 추가 피해를 입힙니다.<br><br><rules>추가 피해량은 적의 최대 체력이 10%~100% 더 많을 경우 그에 따라 증가합니다.</rules><br><hr><br>총 추가 피해량: <scaleAD>@f1@</scaleAD>",
    shortDesc: "적 최대 체력이 더 많을 경우 해당 챔피언에게 추가 피해",
    longDesc:
      "적 챔피언의 최대 체력이 자신보다 많은 정도에 비례해 해당 챔피언에게 5%~15%의 추가 피해를 입힙니다.<br><br><rules>추가 피해량은 적의 최대 체력이 10%~100% 더 많을 경우 그에 따라 증가합니다.</rules>",
    iconPath: "perk-images/Styles/Precision/CutDown/CutDown.png",
    endOfGameStatDescs: ["총 추가 피해량: @eogvar1@"],
  },
  {
    id: 8224,
    name: "무효화 구체",
    majorChangePatchVersion: "",
    tooltip:
      "마법 피해를 받아 체력이 30% 이하가 될 경우, 4초 동안 <font color='#ffffff'>@f2@</font> (+<scaleAD>@f3@</scaleAD>) (+<scaleAP>@f4@</scaleAP>)의 마법 피해를 흡수하는 보호막이 생성됩니다.<br><br>재사용 대기시간: 60초<br><hr><br>흡수한 마법 피해량: @f1@",
    shortDesc: "마법 피해를 받아 체력이 낮아지면 마법 피해를 흡수하는 보호막 생성",
    longDesc:
      "마법 피해를 받아 체력이 30% 이하가 될 경우, 4초 동안 레벨에 비례해 40 ~ 120 (<scaleAP>+주문력의 0.1</scaleAP> 및 <scaleAD>+추가 공격력의 0.15</scaleAD>)의 마법 피해를 흡수하는 보호막이 생성됩니다.<br><br>재사용 대기시간: 60초",
    iconPath: "perk-images/Styles/Sorcery/NullifyingOrb/Pokeshield.png",
    endOfGameStatDescs: ["생성된 보호막 체력: 총 @eogvar1@"],
  },
  {
    id: 8210,
    name: "깨달음",
    majorChangePatchVersion: "",
    tooltip:
      "다음 레벨이 되면 추가 효과 획득:<br>5레벨: <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +5 <br>8레벨: <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +5 <br>11레벨: 챔피언 처치 관여 시 기본 스킬의 남은 재사용 대기시간 20% 감소<br><br><hr><br>추가 스킬 가속: +@f4*100@<br>감소한 시간: @f3@초",
    shortDesc:
      "다음 레벨이 되면 추가 효과 획득:<br>5레벨: <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +5 <br>8레벨: <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +5 <br>11레벨: 챔피언 처치 관여 시 기본 스킬의 남은 재사용 대기시간 20% 감소",
    longDesc:
      "다음 레벨이 되면 추가 효과 획득:<br>5레벨: <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +5 <br>8레벨: <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +5 <br>11레벨: 챔피언 처치 관여 시 기본 스킬의 남은 재사용 대기시간 20% 감소<br>",
    iconPath: "perk-images/Styles/Sorcery/Transcendence/Transcendence.png",
    endOfGameStatDescs: ["감소한 시간: @eogvar1@초"],
  },
  {
    id: 8005,
    name: "집중 공격",
    majorChangePatchVersion: "",
    tooltip:
      "적 챔피언에게 연속으로 3회 기본 공격을 가하면 레벨에 따라 <scaleLevel>@f4@</scaleLevel>의 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'><font color='#48C4B7'>적응형 피해</font></lol-uikit-tooltipped-keyword>를 입히고 적의 약점을 노출시킵니다. 약점이 노출된 적은 6초 동안 모든 상대에게서 <scaleLevel>@f7@%</scaleLevel>의 추가 피해를 입습니다.<br><hr><br>적에게 가한 총 추가 피해량: <scaleAD>@f2@</scaleAD><br>약점 노출로 인한 총 피해량: <scaleAD>@f3@</scaleAD>",
    shortDesc: "적 챔피언을 연속 3회 기본 공격하면 적의 약점이 노출되며 추가 피해를 줌. 약점이 노출된 적은 6초 동안 모든 상대에게서 추가 피해를 받음",
    longDesc:
      "적 챔피언에게 연속으로 3회 기본 공격을 가하면 레벨에 따라 40 ~ 180의 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'><font color='#48C4B7'>적응형 피해</font></lol-uikit-tooltipped-keyword>를 입히고 적의 약점을 노출시킵니다. 약점이 노출된 적은 6초 동안 모든 상대에게서 8 ~ 12%의 추가 피해를 받습니다.",
    iconPath: "perk-images/Styles/Precision/PressTheAttack/PressTheAttack.png",
    endOfGameStatDescs: ["총 피해량: @eogvar1@", "추가 피해량: @eogvar2@", "약점 노출로 인한 피해량: @eogvar3@"],
  },
  {
    id: 8435,
    name: "거울 갑옷",
    majorChangePatchVersion: "",
    tooltip: "마법 저항력이 +6 증가합니다. <br><br>체력이 20 이상 회복되거나 소모품 효과로 체력이 회복되거나 보호막이 생성되면 마법 저항력이 3초간 5% 증가합니다.",
    shortDesc: "마법 저항력 +6 증가 <br>소모품 사용 효과를 포함하여 체력 회복 시 일시적으로 마법 저항력 5% 증가<br>",
    longDesc: "마법 저항력이 +6 증가합니다. <br><br>체력이 20 이상 회복되거나 소모품 효과로 체력이 회복되거나 보호막이 생성되면 마법 저항력이 3초간 5% 증가합니다.",
    iconPath: "perk-images/Styles/Resolve/MirrorShell/MirrorShell.png",
    endOfGameStatDescs: ["추가 마법 저항력: @eogvar1@"],
  },
  {
    id: 8115,
    name: "창공의 검",
    majorChangePatchVersion: "",
    tooltip:
      "<pathDomination>지배</pathDomination> + <pathSorcery>마법</pathSorcery><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathDomination>지배</pathDomination> + <pathSorcery>마법</pathSorcery> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8359,
    name: "도벽",
    majorChangePatchVersion: "8.23",
    tooltip: "스킬을 사용한 후 다음 기본 공격 2회로 각각 5골드 또는 소모품을 획득합니다.<br><br>챔피언에게 공격이 적중했을 때만 보상이 주어집니다.<br><hr><br>골드 획득량: @f1@<br>훔친 아이템: @f3@",
    shortDesc: "스킬 사용 후 기본 공격 시 적 챔피언으로부터 골드와 아이템 획득",
    longDesc: "스킬을 사용한 후 다음 기본 공격 2회로 각각 5골드 또는 소모품을 획득합니다.<br><br>챔피언에게 공격이 적중했을 때만 보상이 주어집니다.",
    iconPath: "perk-images/Styles/Inspiration/Kleptomancy/Kleptomancy.png",
    endOfGameStatDescs: ["획득한 골드: @eogvar1@", "훔친 아이템: @eogvar2@"],
  },
  {
    id: 8352,
    name: "시간 왜곡 물약",
    majorChangePatchVersion: "8.22",
    tooltip:
      "물약이나 비스킷을 사용하면 체력이나 마나 회복량의 50%를 즉시 회복합니다. 또한 물약이나 비스킷의 효과가 지속되는 동안 <speed>이동 속도가 5%</speed> 증가합니다.<br><br><br><hr><br>이동 속도 증가 시간: @f1@초<br>체력 즉시 회복량: 총 @f2@<br>마나 즉시 회복량: 총 @f3@",
    shortDesc:
      "물약이나 비스킷으로 회복량 일부를 즉시 회복. 물약이나 비스킷의 효과가 지속되는 동안 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_MS'>이동 속도</lol-uikit-tooltipped-keyword> 증가",
    longDesc: "물약이나 비스킷을 사용하면 체력이나 마나 회복량의 50%를 즉시 회복합니다. 또한 물약이나 비스킷의 효과가 지속되는 동안 <speed>이동 속도가 5%</speed> 증가합니다.<br><br>",
    iconPath: "perk-images/Styles/Inspiration/TimeWarpTonic/TimeWarpTonic.png",
    endOfGameStatDescs: ["이동 속도 증가 시간: @eogvar1@", "총 체력 즉시 회복량: @eogvar2@", "총 마나 즉시 회복량: @eogvar3@"],
  },
  {
    id: 5003,
    name: "MagicRes",
    majorChangePatchVersion: "",
    tooltip: "마법 저항력 +8",
    shortDesc: "마법 저항력 +8",
    longDesc: "마법 저항력 +8",
    iconPath: "perk-images/StatMods/StatModsMagicResIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8120,
    name: "유령 포로",
    majorChangePatchVersion: "9.9",
    tooltip:
      "자신이 설치한 와드의 지속시간이 끝나면 유령 포로 와드가 남아 90초 동안 시야를 밝힙니다. 적 챔피언이 근처에 오면 유령 포로 와드를 몰아낼 수 있습니다.<br><br>유령 포로 와드가 생성되거나 유령 포로 와드가 적 챔피언을 발견할 때마다 최대 10회까지 중첩되는 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 1.2 또는 추가 주문력 2의 효과를 얻습니다. <br><br>10회 중첩되면 10의 적응형 능력치를 부가적으로 획득합니다.<br><hr><br>획득한 능력치: <scaleAD>+공격력 @f2@</scaleAD><br>생성된 포로 수: @f3@<br>적을 발견한 횟수: @f5@",
    shortDesc:
      "자신이 설치한 와드의 지속시간이 끝나면 유령 포로 와드가 남아 발견될 때까지 시야를 밝히고, 생성된 유령 포로 와드 하나당 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'>적응형</lol-uikit-tooltipped-keyword>으로 공격력 또는 주문력 영구 증가 및 유령 포로 와드가 적 챔피언 발견 시 추가로 증가",
    longDesc:
      "자신이 설치한 와드의 지속시간이 끝나면 유령 포로 와드가 남아 90초 동안 시야를 밝힙니다. 적 챔피언이 근처에 오면 유령 포로 와드를 몰아낼 수 있습니다.<br><br>유령 포로 와드가 생성되거나 유령 포로 와드가 적 챔피언을 발견할 때마다 최대 10회까지 중첩되는 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 1.2 또는 추가 주문력 2의 효과를 얻습니다. <br><br>10회 중첩되면 10의 적응형 능력치를 부가적으로 획득합니다.",
    iconPath: "perk-images/Styles/Domination/GhostPoro/GhostPoro.png",
    endOfGameStatDescs: ["생성된 유령 포로 수: @eogvar3@", "적을 발견한 횟수: @eogvar1@"],
  },
  {
    id: 8134,
    name: "영리한 사냥꾼",
    majorChangePatchVersion: "",
    tooltip:
      "<b>아이템 가속</b>이 <attention>20</attention>+<i>현상금 사냥꾼</i> 중첩 1회당 <attention>6</attention> 증가합니다. (장신구 포함)<br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.<br><br><rules>아이템 가속은 재사용 대기시간이 있는 모든 아이템에 적용됩니다. </rules><br><br>아이템 사용 횟수 (장신구 포함): @f3@<br><hr><br><u>획득할 수 없는 현상금</u>",
    shortDesc:
      "적 챔피언당 <b>1회</b> 한정 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 영구적으로 아이템 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>가속</lol-uikit-tooltipped-keyword> 증가 (장신구 포함)",
    longDesc:
      "<b>아이템 가속</b>이 <attention>20</attention>+<i>현상금 사냥꾼</i> 중첩 1회당 <attention>6</attention> 증가합니다. (장신구 포함)<br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.<br><br><rules>아이템 가속은 재사용 대기시간이 있는 모든 아이템에 적용됩니다. </rules>",
    iconPath: "perk-images/Styles/Domination/IngeniousHunter/IngeniousHunter.png",
    endOfGameStatDescs: ["총 중첩 수: @eogvar2@", "아이템 사용 횟수 (장신구 포함): @eogvar1@"],
  },
  {
    id: 8351,
    name: "빙결 강화",
    majorChangePatchVersion: "",
    tooltip:
      "적 챔피언을 이동 불가 상태로 만들면 대상에게서 3줄기의 빙결 광선이 자신과 근처 다른 챔피언을 향해 뻗어 나와 3초 (+이동 불가 효과 지속시간의 100%) 동안 적들을 둔화하고 자신을 제외한 아군에게 입히는 피해를 15% 감소시키는 빙결 영역을 생성합니다. <br><br>재사용 대기시간: 25초<br>둔화: @f3@% = 30%<healing>+@f4@% (%i:scaleHealShield%)</healing><scaleAP>+@f5@% (%i:scaleAP%)</scaleAP><scaleAD>+@f6@% (%i:scaleAD%)</scaleAD> <br>적 챔피언 둔화 시간: @f1@초<br>감소한 피해량: @f2@",
    shortDesc: "적 챔피언을 이동 불가 상태로 만들면 3줄기의 빙결 광선이 뻗어 나와 근처 적들을 둔화하고 아군에게 입히는 피해를 감소시킵니다. 재사용 대기시간은 25초입니다.",
    longDesc:
      "적 챔피언을 이동 불가 상태로 만들면 대상에게서 3줄기의 빙결 광선이 자신과 근처 다른 챔피언을 향해 뻗어 나와 3초(+이동 불가 효과 지속시간의 100%) 동안 적들을 30%(+회복 및 보호막 효과 10%당 9%)(+주문력 100당 3%)(+추가 공격력 100당 4%) 둔화하고 자신을 제외한 아군에게 입히는 피해를 15% 감소시키는 빙결 영역을 생성합니다. <br><br>재사용 대기시간은 25초입니다.",
    iconPath: "perk-images/Styles/Inspiration/GlacialAugment/GlacialAugment.png",
    endOfGameStatDescs: ["적 챔피언 둔화 시간: @eogvar1@초", "감소한 피해량: @eogvar2@"],
  },
  {
    id: 8242,
    name: "불굴의 의지",
    majorChangePatchVersion: "",
    tooltip:
      "강인함이 10%, 둔화 저항이 10% 증가합니다. 잃은 체력에 비례하여 강인함은 20%, 둔화 저항은 20% 추가로 증가합니다. 체력이 30%일 때 최대로 증가합니다. <br>현재 추가 강인함: @f1@%<br>현재 추가 둔화 저항: @f2@%<br><br>강인함 및 둔화 저항이 증가된 총 전투 시간: @f6@초",
    shortDesc: "잃은 체력에 비례하여 상승하는 강인함 효과 소폭 증가 ",
    longDesc: "강인함이 10%, 둔화 저항이 10% 증가합니다. 잃은 체력에 비례하여 강인함은 20%, 둔화 저항은 20% 추가로 증가합니다. 체력이 30%일 때 최대로 증가합니다. ",
    iconPath: "perk-images/Styles/Sorcery/Unflinching/Unflinching.png",
    endOfGameStatDescs: ["강인함 최대 상태 전투 시간: @eogvar1@초"],
  },
  {
    id: 8401,
    name: "보호막 강타",
    majorChangePatchVersion: "8.23",
    tooltip:
      "보호막이 지속되는 동안 <scaleLevel>@f6@</scaleLevel>의 추가 방어력과 마법 저항력을 얻습니다.<br><br>새로운 보호막을 얻으면 적 챔피언에게 다음 기본 공격 시 <scaleLevel>@f4@</scaleLevel><scaleHealth>(+@f2@)</scaleHealth><scaleMana>(+새로운 보호막 흡수량의 8.5%)</scaleMana>에 해당하는 마법 피해를 추가로 입힙니다.<br><br>이 효과는 보호막이 사라진 후 최대 2초까지 발동 가능합니다.<br><hr><br>적에게 입힌 피해량: 총 @f1@",
    shortDesc:
      "보호막을 얻으면 적 챔피언에게 다음 기본 공격 시 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword> 피해",
    longDesc:
      "보호막이 지속되는 동안 레벨에 따라 <scaleLevel>1~10</scaleLevel>의 방어력과 마법 저항력을 얻습니다.<br><br>새로운 보호막을 얻으면 적 챔피언에게 다음 기본 공격 시 <scaleLevel>5~30</scaleLevel><scaleHealth>(+추가 체력의 1.5%)</scaleHealth><scaleMana>(+새로운 보호막 흡수량의 8.5%)</scaleMana>에 해당하는 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword> 피해를 입힙니다.<br><br>이 효과는 보호막이 사라진 후 최대 2초까지 발동 가능합니다.",
    iconPath: "perk-images/Styles/Resolve/MirrorShell/MirrorShell.png",
    endOfGameStatDescs: ["총 피해량: @eogvar1@"],
  },
  {
    id: 9111,
    name: "승전보",
    majorChangePatchVersion: "",
    tooltip: "챔피언 처치 또는 어시스트 시 잃은 체력의 12%를 회복하며 추가로 20골드를 획득합니다. <br><hr><br>총 체력 회복량: <scaleAD>@f1@</scaleAD><br>획득한 추가 골드: 총 <scaleAD>@f2@</scaleAD>",
    shortDesc: "챔피언 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 잃은 체력의 12%를 회복하며 추가로 20골드 획득 ",
    longDesc:
      "챔피언 처치 또는 어시스트 시 잃은 체력의 12%를 회복하며 추가로 20골드를 획득합니다. <br><br><hr><br><i>'가장 위험한 게임을 하는 자만이 진정 승리의 환희를 맛보았다고 말할 수 있다.' <br>—녹서스 검투사</i>",
    iconPath: "perk-images/Styles/Precision/Triumph.png",
    endOfGameStatDescs: ["총 체력 회복량: @eogvar1@", "획득한 추가 골드: 총 @eogvar2@"],
  },
  {
    id: 8105,
    name: "끈질긴 사냥꾼",
    majorChangePatchVersion: "9.9",
    tooltip:
      "전투에서 벗어나 있을 때 <speed>이동 속도가 5</speed> 상승합니다. <i>현상금 사냥꾼</i> 중첩 하나당 <speed>8</speed>씩 추가됩니다.<br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.<br><br>현재 끈질긴 사냥꾼 증가량: <speed>이동 속도 @f3.2@%</speed><br><hr><br><u>획득할 수 없는 현상금</u>",
    shortDesc:
      "적 챔피언당 <b>1회</b> 한정 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 <b>전투에서 벗어나 있을 때 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_MS'>이동 속도</lol-uikit-tooltipped-keyword></b> 영구 증가 ",
    longDesc:
      "전투에서 벗어나 있을 때 <speed>이동 속도가 5</speed> 상승합니다. <i>현상금 사냥꾼</i> 중첩 하나당 <speed>8</speed>씩 추가됩니다.<br><br>각 적 챔피언을 처치하는 데 처음으로 관여할 때마다 <i>현상금 사냥꾼</i> 중첩을 얻을 수 있습니다.",
    iconPath: "perk-images/Styles/Domination/RelentlessHunter/RelentlessHunter.png",
    endOfGameStatDescs: ["총 중첩 수: @eogvar2@", "<speed>이동 속도 @eogvar1@%</speed> 증가"],
  },
  {
    id: 8454,
    name: "거대 괴수",
    majorChangePatchVersion: "",
    tooltip:
      "<pathResolve>결의</pathResolve> + <pathDomination>지배</pathDomination> <br>체력 +0 ~ 0 (레벨에 비례)<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathResolve>결의</pathResolve> + <pathDomination>지배</pathDomination> 세트 보너스</pathBonus>",
    longDesc:
      "체력 +0 ~ 0 (레벨에 비례)<br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8275,
    name: "빛의 망토",
    majorChangePatchVersion: "8.11",
    tooltip:
      "소환사 주문 사용 후 2초 동안 <speed>이동 속도</speed>가 증가하고 유닛을 통과할 수 있습니다.<br><hr><br>증가: 소환사 주문 재사용 대기시간에 따라 <speed>이동 속도가 5%~25%</speed> 증가합니다. (재사용 대기시간이 길수록 <speed>이동 속도</speed>가 더 많이 증가합니다.) <br><hr><br>활성화 횟수: @f1@",
    shortDesc: "소환사 주문 사용 후 잠시 동안 <speed>이동 속도</speed> 증가 및 유닛 통과 가능",
    longDesc:
      "소환사 주문 사용 후 2초 동안 <speed>이동 속도</speed>가 증가하고 유닛을 통과할 수 있습니다.<br><br>증가: 소환사 주문 재사용 대기시간에 따라 <speed>이동 속도가 5%~25%</speed> 증가합니다. (재사용 대기시간이 길수록 <speed>이동 속도</speed>가 더 많이 증가합니다.) ",
    iconPath: "perk-images/Styles/Sorcery/NimbusCloak/6361.png",
    endOfGameStatDescs: ["활성화 횟수: @eogvar1@"],
  },
  {
    id: 8207,
    name: "불가사의",
    majorChangePatchVersion: "",
    tooltip:
      "<pathSorcery>마법</pathSorcery> + <pathInspiration>영감</pathInspiration><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathSorcery>마법</pathSorcery> + <pathInspiration>영감</pathInspiration> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8439,
    name: "여진",
    majorChangePatchVersion: "9.9",
    tooltip:
      "적을 이동 불가 상태로 만들면 2.5초 동안 방어력과 마법 저항력이 증가하며, 폭발이 일어나 근처 적에게 마법 피해를 줍니다.<br><br>피해량: <scaleLevel>@f4@</scaleLevel> <scaleHealth>(+@f5@)</scaleHealth> <br>방어력 증가: @f8@<scaleArmor> (+@f2@)</scaleArmor><br>마법 저항력 증가: @f8@<scaleMR> (+@f3@)</scaleMR><br>재사용 대기시간: 20초<br><hr><br>적에게 입힌 총 피해량: <scaleAD>@f1@</scaleAD><br>감소한 총 피해량: <scaleHealth>@f9@</scaleHealth>",
    shortDesc:
      "적 챔피언을 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Immobilize'>이동 불가</lol-uikit-tooltipped-keyword> 상태로 만들면 방어력/마법 저항력 증가 및 잠시 후 주변에 큰 마법 피해",
    longDesc:
      "적을 이동 불가 상태로 만들면 2.5초 동안 35+추가 방어력 및 마법 저항력의 80%만큼 방어력과 마법 저항력이 증가하며 폭발이 일어나 근처 적에게 마법 피해를 줍니다.<br><br>피해량: 25~120 (+추가 체력의 8%)<br>재사용 대기시간: 20초<br><br>여진 추가 저항력: 80~150 (레벨에 비례)<br>",
    iconPath: "perk-images/Styles/Resolve/VeteranAftershock/VeteranAftershock.png",
    endOfGameStatDescs: ["적에게 입힌 총 피해량: @eogvar1@", "감소한 총 피해량: @eogvar2@"],
  },
  {
    id: 8109,
    name: "악의 거장 ",
    majorChangePatchVersion: "",
    tooltip:
      "<pathDomination>지배</pathDomination> + <pathInspiration>영감</pathInspiration><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathDomination>지배</pathDomination> + <pathInspiration>영감</pathInspiration> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 5002,
    name: "Armor",
    majorChangePatchVersion: "",
    tooltip: "방어력 +6",
    shortDesc: "방어력 +6",
    longDesc: "방어력 +6",
    iconPath: "perk-images/StatMods/StatModsArmorIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8414,
    name: "거대한 괴수",
    majorChangePatchVersion: "",
    tooltip: "<pathResolve>결의</pathResolve> + <pathPrecision>정밀</pathPrecision> <br>체력 +0 ~ 0 (레벨에 비례)<br>공격 속도 +0%",
    shortDesc: "<pathBonus><pathResolve>결의</pathResolve> + <pathPrecision>정밀</pathPrecision> 세트 보너스</pathBonus>",
    longDesc: "체력 +0 ~ 0 (레벨에 비례)<br>공격 속도 +0%",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 5008,
    name: "Adaptive",
    majorChangePatchVersion: "",
    tooltip: "<scaleAD>+공격력 @f2@</scaleAD>",
    shortDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형 능력치</font></lol-uikit-tooltipped-keyword> +9",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형 능력치</font></lol-uikit-tooltipped-keyword> +9",
    iconPath: "perk-images/StatMods/StatModsAdaptiveForceIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8320,
    name: "현자",
    majorChangePatchVersion: "",
    tooltip: "<pathInspiration>영감</pathInspiration> + <pathResolve>결의</pathResolve><br>체력 +0 ~ 0 (레벨에 비례)",
    shortDesc: "<pathBonus><pathInspiration>영감</pathInspiration> + <pathResolve>결의</pathResolve> 세트 보너스</pathBonus>",
    longDesc: "체력 +0 ~ 0 (레벨에 비례)",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8319,
    name: "점성술사",
    majorChangePatchVersion: "",
    tooltip:
      "<pathInspiration>영감</pathInspiration> + <pathSorcery>마법</pathSorcery><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathInspiration>영감</pathInspiration> + <pathSorcery>마법</pathSorcery> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 5001,
    name: "HealthScaling",
    majorChangePatchVersion: "",
    tooltip: "체력 +@f1@ (레벨에 비례)",
    shortDesc: "체력 +15~140 (레벨에 비례)",
    longDesc: "체력 +15~140 (레벨에 비례)",
    iconPath: "perk-images/StatMods/StatModsHealthScalingIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8430,
    name: "강철 피부",
    majorChangePatchVersion: "",
    tooltip: "방어력이 +5만큼 증가합니다. <br><br>체력이 20 이상 회복되거나 소모품 효과로 체력이 회복되거나 보호막이 생성되면 방어력이 3초간 5% 증가합니다.",
    shortDesc: "방어력 +5 증가 <br>소모품 사용 효과를 포함하여 체력 회복 시 일시적으로 방어력 5% 증가",
    longDesc: "방어력이 +5만큼 증가합니다. <br><br>체력이 20 이상 회복되거나 소모품 효과로 체력이 회복되거나 보호막이 생성되면 방어력이 3초간 5% 증가합니다.",
    iconPath: "perk-images/Styles/Resolve/IronSkin/IronSkin.png",
    endOfGameStatDescs: ["활성화된 게임: @eogvar1@%"],
  },
  {
    id: 8014,
    name: "최후의 일격",
    majorChangePatchVersion: "",
    tooltip: "체력이 40% 이하인 적 챔피언에게 주는 피해량이 8% 증가합니다.<br><hr><br>적에게 가한 총 추가 피해량: <scaleAD>@f1@</scaleAD>",
    shortDesc: "체력이 낮은 적 챔피언에게 입히는 피해량 증가",
    longDesc: "체력이 40% 이하인 적 챔피언에게 주는 피해량이 8% 증가합니다.",
    iconPath: "perk-images/Styles/Precision/CoupDeGrace/CoupDeGrace.png",
    endOfGameStatDescs: ["총 추가 피해량: @eogvar1@"],
  },
  {
    id: 5007,
    name: "CDRScaling",
    majorChangePatchVersion: "",
    tooltip: "스킬 가속 +@f1@",
    shortDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +8 ",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_CDR'>스킬 가속</lol-uikit-tooltipped-keyword> +8 ",
    iconPath: "perk-images/StatMods/StatModsCDRScalingIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8021,
    name: "기민한 발놀림",
    majorChangePatchVersion: "",
    tooltip:
      "공격 또는 이동 시 충전 중첩이 쌓입니다. 중첩이 100회 쌓이면 충전 상태로 다음 공격을 할 수 있습니다.<br><br>충전 상태로 공격 시 <font color='#ffffff'>@f2@</font><scaleAD>(+@f3@)</scaleAD><scaleAP>(+@f4@)</scaleAP>만큼 체력이 회복되며 1초 동안 <speed>이동 속도가 @f5*100@%</speed> 증가합니다.<br><rules><br>미니언으로부터 받는 회복 효과는 원거리 챔피언의 경우 10%, 근접 챔피언의 경우 20% 적용됩니다.<br></rules><hr><br>총 회복량: @f1@",
    shortDesc: "공격 및 이동 시 충전. 충전 중첩 100회 상태로 공격 시 체력 회복 및 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_MS'>이동 속도</lol-uikit-tooltipped-keyword> 증가",
    longDesc:
      "공격 또는 이동 시 충전 중첩이 쌓입니다. 중첩이 100회에 도달하면 충전 상태로 다음 공격을 할 수 있습니다.<br><br>충전 상태로 공격 시 10~100(+추가 공격력의 0.4, +주문력의 0.3)에 해당하는 체력이 회복되며 1초 동안 <speed>이동 속도가 20%</speed> 증가합니다.<br><br>미니언으로부터 받는 회복 효과는 원거리 챔피언의 경우 10%, 근접 챔피언의 경우 20% 적용됩니다.",
    iconPath: "perk-images/Styles/Precision/FleetFootwork/FleetFootwork.png",
    endOfGameStatDescs: ["총 회복량: @eogvar1@"],
  },
  {
    id: 8226,
    name: "마나순환 팔찌",
    majorChangePatchVersion: "8.7",
    tooltip:
      "적 챔피언에게 스킬을 적중하면 최대 마나가 영구적으로 25만큼 증가합니다. (최대 마나량: 250)<br><br>최대 마나량 250에 도달하면 5초마다 잃은 마나의 1%를 회복합니다.<br><br>재사용 대기시간: 15초<br><hr><br>최대 마나 증가량: @f1@<br>회복된 마나: 총 @f2@",
    shortDesc: "적 챔피언에게 스킬을 적중하면 최대 마나가 영구적으로 25만큼 증가합니다. (최대 마나량: 250)<br><br>최대 마나량 250에 도달하면 5초마다 잃은 마나의 1%를 회복합니다.",
    longDesc:
      "적 챔피언에게 스킬을 적중하면 최대 마나가 영구적으로 25만큼 증가합니다. (최대 마나량: 250)<br><br>최대 마나량 250에 도달하면 5초마다 잃은 마나의 1%를 회복합니다.<br><br>재사용 대기시간: 15초",
    iconPath: "perk-images/Styles/Sorcery/ManaflowBand/ManaflowBand.png",
    endOfGameStatDescs: ["최대 마나 증가량: @eogvar1@", "회복된 마나: 총 @eogvar2@"],
  },
  {
    id: 8451,
    name: "과잉성장",
    majorChangePatchVersion: "8.23",
    tooltip:
      "근처에서 몬스터 또는 적 미니언이 8마리 죽을 때마다 생명의 정수를 흡수해 최대 체력이 영구적으로 3씩 증가합니다.<br><br>몬스터 또는 적 미니언을 120마리 흡수하면 최대 체력이 추가로 3.5% 증가합니다.<br><hr><br>최대 체력 증가량: 총 <scaleHealth>@f1@</scaleHealth><br>흡수한 적의 수: <passiveText>@f2@</passiveText>",
    shortDesc: "근처에서 몬스터 또는 미니언이 죽을 때마다 최대 체력 영구 증가",
    longDesc:
      "근처에서 몬스터 또는 적 미니언이 8마리 죽을 때마다 생명의 정수를 흡수해 최대 체력이 영구적으로 3씩 증가합니다.<br><br>몬스터 또는 적 미니언을 120마리 흡수하면 최대 체력이 추가로 3.5% 증가합니다.",
    iconPath: "perk-images/Styles/Resolve/Overgrowth/Overgrowth.png",
    endOfGameStatDescs: ["총 추가 체력: @eogvar1@"],
  },
  {
    id: 8313,
    name: "완벽한 타이밍",
    majorChangePatchVersion: "",
    tooltip:
      "게임 시작 시 초시계 키트 아이템을 받습니다. 이 아이템은 14분 후 초시계 아이템으로 변합니다. 챔피언 처치 관여 시마다 이 시간이 120초 감소합니다.<br><br>초시계 아이템은 단 한 번 사용할 수 있으며, 사용 시 2.5초 동안 경직 효과를 얻습니다.",
    shortDesc:
      "초시계 키트 획득. 14분 후부터 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Stasis'>경직</lol-uikit-tooltipped-keyword> 효과 1회 사용 가능 <br><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시마다 사용 가능 시점 120초씩 단축",
    longDesc:
      "게임 시작 시 초시계 키트 아이템을 받습니다. 이 아이템은 14분 후 초시계 아이템으로 변합니다. 챔피언 처치 관여 시마다 이 시간이 120초 감소합니다.<br><br>초시계 아이템은 단 한 번 사용할 수 있으며, 사용 시 2.5초 동안 경직 효과를 얻습니다.",
    iconPath: "perk-images/Styles/Inspiration/PerfectTiming/PerfectTiming.png",
    endOfGameStatDescs: ["타이밍: 완벽"],
  },
  {
    id: 9103,
    name: "전설: 핏빛 길",
    majorChangePatchVersion: "",
    tooltip:
      "<i>전설</i> 중첩당 생명력 흡수가 0.6% 증가합니다. (<statGood>최대 전설 중첩 횟수: 15</statGood>)<br><br>챔피언 처치 관여, 에픽 몬스터 처치 관여, 대형 몬스터 처치, 미니언 처치 시마다 <i>전설</i> 중첩을 얻습니다.<br><hr><br>생명력 흡수 증가: 총 <scaleAD>@f1*100@%</scaleAD> (<statGood>최대 15중첩 중 @f3@ 획득</statGood>)<br>다음 중첩까지 진행률: @f2@%",
    shortDesc:
      "적 챔피언 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 영구적으로 <b>생명력 흡수</b> 효과 획득. 다른 전설 룬에 비해 게임 초반에 약하고 후반에 강한 룬",
    longDesc:
      "<i>전설</i> 중첩당 생명력 흡수가 0.6% 증가합니다. (<statGood>최대 전설 중첩 횟수: 15</statGood>)<br><br>챔피언 처치 관여, 에픽 몬스터 처치 관여, 대형 몬스터 처치, 미니언 처치 시마다 <i>전설</i> 중첩을 얻습니다.",
    iconPath: "perk-images/Styles/Precision/LegendBloodline/LegendBloodline.png",
    endOfGameStatDescs: ["완료 시간: @eogvar1@:@eogvar2@"],
  },
  {
    id: 8114,
    name: "불멸의 도살자",
    majorChangePatchVersion: "",
    tooltip:
      "<pathDomination>지배</pathDomination> + <pathResolve>결의</pathResolve><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD><br>체력 +0 ~ 0 (레벨에 비례)",
    shortDesc: "<pathBonus><pathDomination>지배</pathDomination> + <pathResolve>결의</pathResolve> 세트 보너스</pathBonus>",
    longDesc:
      "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>체력 +0 ~ 0 (레벨에 비례)",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8230,
    name: "난입",
    majorChangePatchVersion: "",
    tooltip:
      "4초 안에 한 챔피언에게 기본 공격 또는 <b>개별</b> 스킬 3회를 적중시키면 레벨에 따라 <speed>15~40%의 이동 속도</speed>와 75%의 둔화 저항 효과를 얻습니다. <hr>근접 챔피언의 경우 <speed>이동 속도가 30~60%</speed>까지 증가합니다.<hr>지속시간: 3초<br>재사용 대기시간: @f4@초<br>추가 이동 속도: @f2@%",
    shortDesc: "한 챔피언에게 기본 공격 또는 <b>개별</b> 스킬 3회 적중 시 일시적으로 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_MS'>이동 속도</lol-uikit-tooltipped-keyword> 증가 ",
    longDesc:
      "4초 안에 한 챔피언에게 기본 공격 또는 <b>개별</b> 스킬 3회를 적중시키면 레벨에 따라 <speed>15~40%의 이동 속도</speed>와 75%의 둔화 저항 효과를 얻습니다. <hr>근접 챔피언의 경우 <speed>이동 속도가 30~60%</speed>까지 증가합니다.<hr>지속시간: 3초<br>재사용 대기시간: 10~30초",
    iconPath: "perk-images/Styles/Sorcery/PhaseRush/PhaseRush.png",
    endOfGameStatDescs: ["총 활성화 횟수: @eogvar1@"],
  },
  {
    id: 8318,
    name: "무자비한 선지자",
    majorChangePatchVersion: "",
    tooltip:
      "<pathInspiration>영감</pathInspiration> + <pathDomination>지배</pathDomination><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "<pathBonus><pathInspiration>영감</pathInspiration> + <pathDomination>지배</pathDomination> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8316,
    name: "미니언 해체분석기",
    majorChangePatchVersion: "9.6",
    tooltip:
      "게임 시작 시, 공격로 미니언을 즉시 처치하고 흡수하는 미니언 해체분석기 3개를 받습니다. 미니언 해체분석기 아이템은 게임 시작 후 180초 동안 재사용 대기 상태입니다.<br><br>이 아이템으로 미니언을 흡수하면 이후 동일한 종류의 미니언을 대상으로 6%의 추가 피해를 입히며, 동일한 종류의 미니언을 추가 흡수 시마다 3%의 추가 피해를 입힙니다.<br><br><hr><br>근접 미니언 대상 추가 피해: +@f1@%<br>원거리 미니언 대상 추가 피해: +@f2@%<br>공성 미니언 대상 추가 피해: +@f3@%",
    shortDesc: "미니언 해체분석기 3개를 보유하고 게임 시작. 해당 아이템으로 미니언 처치 시 동일한 종류의 미니언에게 추가 피해 적용",
    longDesc:
      "게임 시작 시, 공격로 미니언을 즉시 처치하고 흡수하는 미니언 해체분석기 3개를 받습니다. 미니언 해체분석기 아이템은 게임 시작 후 180초 동안 재사용 대기 상태입니다.<br><br>이 아이템으로 미니언을 흡수하면 이후 동일한 종류의 미니언을 대상으로 6%의 추가 피해를 입히며, 동일한 종류의 미니언을 추가 흡수 시마다 3%의 추가 피해를 입힙니다.<br>",
    iconPath: "perk-images/Styles/Inspiration/MinionDematerializer/MinionDematerializer.png",
    endOfGameStatDescs: ["미니언에게 입힌 추가 피해량: @eogvar1@"],
  },
  {
    id: 8463,
    name: "생명의 샘",
    majorChangePatchVersion: "",
    tooltip: "적 챔피언의 이동을 방해하면 4초 동안 표식을 남깁니다.<br><br>표식이 남겨진 적을 공격하는 아군 챔피언은 2초에 걸쳐 5 + 나의 최대 체력의 1%에 해당하는 체력을 회복합니다. ",
    shortDesc: "적 챔피언 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_ImpairMov'>이동 방해</lol-uikit-tooltipped-keyword> 시 표식을 남겨, 아군이 해당 적 공격 시 체력 회복 ",
    longDesc: "적 챔피언의 이동을 방해하면 4초 동안 표식을 남깁니다.<br><br>표식이 남겨진 적을 공격하는 아군 챔피언은 2초에 걸쳐 5 + 나의 최대 체력의 1%에 해당하는 체력을 회복합니다. ",
    iconPath: "perk-images/Styles/Resolve/FontOfLife/FontOfLife.png",
    endOfGameStatDescs: ["아군 총 회복량: @eogvar1@"],
  },
  {
    id: 7000,
    name: "Template",
    majorChangePatchVersion: "",
    tooltip: "",
    shortDesc: "",
    longDesc: "",
    iconPath: "perk-images/Template/7000.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8304,
    name: "마법의 신발",
    majorChangePatchVersion: "9.9",
    tooltip:
      "게임 시작 12분 후 약간 신비한 신발 아이템을 얻습니다. 그 전까지는 신발류 아이템을 구매할 수 없습니다. 챔피언 처치에 관여할 때마다 장화 획득 시점이 45초씩 앞당겨집니다.<br><br>약간 신비한 신발 아이템으로 <speed>이동 속도가 10</speed> 증가합니다.<br><hr><br><scaleAD>장화 획득 시점:</scaleAD> @f1@:@f2@@f3@",
    shortDesc:
      "게임 시작 후 12분에 장화 무료 획득. 그 전까지 신발류 아이템 구매 불가. 챔피언 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시마다 장화 획득 시점이 45초 앞당겨짐",
    longDesc:
      "게임 시작 12분 후 약간 신비한 신발 아이템을 얻습니다. 그 전까지는 신발류 아이템을 구매할 수 없습니다. 챔피언 처치에 관여할 때마다 장화 획득 시점이 45초씩 앞당겨집니다.<br><br>약간 신비한 신발 아이템으로 <speed>이동 속도가 10</speed> 증가합니다.",
    iconPath: "perk-images/Styles/Inspiration/MagicalFootwear/MagicalFootwear.png",
    endOfGameStatDescs: ["장화 획득 시점: @eogvar1@:@eogvar2@@eogvar3@"],
  },
  {
    id: 8236,
    name: "폭풍의 결집",
    majorChangePatchVersion: "",
    tooltip:
      "10분마다 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 주문력 또는 공격력을 얻습니다.<br><br><i>10분</i>: + 주문력 8 또는 공격력 5 <br><i>20분</i>: + 주문력 24 또는 공격력 14<br><i>30분</i>: + 주문력 48 또는 공격력 29<br><i>40분</i>: + 주문력 80 또는 공격력 48<br><i>50분</i>: + 주문력 120 또는 공격력 72<br><i>60분</i>: + 주문력 168 또는 공격력 101<br>등등...<br><hr><br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "게임이 진행됨에 따라 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'>적응형</lol-uikit-tooltipped-keyword> 공격력 또는 주문력 획득량 증가",
    longDesc:
      "10분마다 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 주문력 또는 공격력을 얻습니다.<br><br><i>10분</i>: + 주문력 8 또는 공격력 5 <br><i>20분</i>: + 주문력 24 또는 공격력 14<br><i>30분</i>: + 주문력 48 또는 공격력 29<br><i>40분</i>: + 주문력 80 또는 공격력 48<br><i>50분</i>: + 주문력 120 또는 공격력 72<br><i>60분</i>: + 주문력 168 또는 공격력 101<br>등등...",
    iconPath: "perk-images/Styles/Sorcery/GatheringStorm/GatheringStorm.png",
    endOfGameStatDescs: ["총 추가 공격력/주문력: @eogvar1@"],
  },
  {
    id: 8009,
    name: "침착",
    majorChangePatchVersion: "8.7",
    tooltip:
      "적 챔피언에게 피해를 입히면 4초 동안 초당 마나 재생이 @RegenAmount@ (원거리 챔피언은 80%) 증가합니다. 기력 기반 챔피언은 초당 1.5의 기력을 얻습니다.<br><br>처치 관여 시 최대 마나 또는 기력의 15%를 돌려받습니다. <br><hr><br>회복된 마나/기력: @f1@<br>",
    shortDesc: "적 챔피언에게 피해를 입히면 마나 또는 기력 재생량 증가. 처치 관여 시 마나 또는 기력 회복",
    longDesc:
      "적 챔피언에게 피해를 입히면 4초 동안 초당 마나 재생이 1.5~11 (원거리 챔피언은 80%) 증가합니다. 기력 기반 챔피언은 초당 1.5의 기력을 얻습니다.<br><br>처치 관여 시 최대 마나 또는 기력의 15%를 돌려받습니다. ",
    iconPath: "perk-images/Styles/Precision/PresenceOfMind/PresenceOfMind.png",
    endOfGameStatDescs: ["회복된 마나/기력: @eogvar1@"],
  },
  {
    id: 8006,
    name: "영원한 승리자",
    majorChangePatchVersion: "",
    tooltip: "<pathPrecision>정밀</pathPrecision> + <pathResolve>결의</pathResolve><br>공격 속도 +0%<br>체력 +0 ~ 0 (레벨에 비례)",
    shortDesc: "<pathBonus><pathPrecision>정밀</pathPrecision> + <pathResolve>결의</pathResolve> 세트 보너스</pathBonus>",
    longDesc: "공격 속도 +0%<br>체력 +0 ~ 0 (레벨에 비례)",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 9104,
    name: "전설: 민첩함",
    majorChangePatchVersion: "",
    tooltip:
      "공격 속도가 3% 증가하며 <i>전설</i> 중첩당 1.5%의 공격 속도가 추가로 증가합니다. (<statGood>최대 전설 중첩 횟수: 10</statGood>)<br><br>챔피언 처치 관여, 에픽 몬스터 처치 관여, 대형 몬스터 처치, 미니언 처치 시마다 <i>전설</i> 중첩을 얻습니다.<br><hr><br>공격 속도 증가: 총 <scaleAD>@f1*100@%</scaleAD> (<statGood>최대 10중첩 중 @f3@ 획득</statGood>)<br>다음 중첩까지 진행률: @f2@%",
    shortDesc: "적 챔피언 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시 영구적으로 <b>공격 속도</b> 증가 ",
    longDesc:
      "공격 속도가 3% 증가하며 <i>전설</i> 중첩당 1.5%의 공격 속도가 추가로 증가합니다. (<statGood>최대 전설 중첩 횟수: 10</statGood>)<br><br>챔피언 처치 관여, 에픽 몬스터 처치 관여, 대형 몬스터 처치, 미니언 처치 시마다 <i>전설</i> 중첩을 얻습니다.",
    iconPath: "perk-images/Styles/Precision/LegendAlacrity/LegendAlacrity.png",
    endOfGameStatDescs: ["완료 시간: @eogvar1@:@eogvar2@"],
  },
  {
    id: 8416,
    name: "거인의 지혜",
    majorChangePatchVersion: "",
    tooltip: "<pathResolve>결의</pathResolve> + <pathInspiration>영감</pathInspiration><br>체력 +0 ~ 0 (레벨에 비례)",
    shortDesc: "<pathBonus><pathResolve>결의</pathResolve> + <pathInspiration>영감</pathInspiration> 세트 보너스</pathBonus>",
    longDesc: "체력 +0 ~ 0 (레벨에 비례)",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 5005,
    name: "AttackSpeed",
    majorChangePatchVersion: "",
    tooltip: "공격 속도 +10%",
    shortDesc: "공격 속도 +10%",
    longDesc: "공격 속도 +10%",
    iconPath: "perk-images/StatMods/StatModsAttackSpeedIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8306,
    name: "마법공학 점멸기",
    majorChangePatchVersion: "",
    tooltip:
      "점멸이 재사용 대기 중일 때 <i>마법공학 점멸</i>로 대체됩니다.<br><br><i>마법공학 점멸</i>: 2초간 정신을 집중한 뒤 다른 지점으로 도약합니다.<br><br>재사용 대기시간: 20초. 챔피언과 전투에 돌입할 경우 10초의 재사용 대기시간이 시작됩니다.",
    shortDesc: "점멸이 재사용 대기 중일 때 <i>마법공학 점멸</i>로 대체됨<br><br><i>마법공학 점멸</i>: 정신 집중 후 다른 지점으로 순간적으로 이동",
    longDesc:
      "점멸이 재사용 대기 중일 때 <i>마법공학 점멸</i>로 대체됩니다.<br><br><i>마법공학 점멸</i>: 2초간 정신을 집중한 뒤 다른 지점으로 도약합니다.<br><br>재사용 대기시간: 20초. 챔피언과 전투에 돌입할 경우 10초의 재사용 대기시간이 시작됩니다.",
    iconPath: "perk-images/Styles/Inspiration/HextechFlashtraption/HextechFlashtraption.png",
    endOfGameStatDescs: ["마법공학 점멸 횟수: @eogvar1@"],
  },
  {
    id: 8465,
    name: "수호자",
    majorChangePatchVersion: "",
    tooltip:
      "자신으로부터 350유닛 내에 있는 아군이나 자신이 스킬의 대상으로 삼은 아군을 2.5초 동안 <i>보호</i>합니다. <i>보호</i>하는 중 자신과 아군 중 한 명이 <i>보호</i>의 지속시간 동안 어느 정도 피해를 입으면 둘 모두에게 1.5초 동안 보호막이 생성됩니다.<br><hr><br>재사용 대기시간: <scaleLevel>@f5@</scaleLevel>초<br>현재 보호막 체력: <scaleLevel>@f2@</scaleLevel><scaleAP>(+@f3@)</scaleAP><scaleHealth>(+@f4@)</scaleHealth>",
    shortDesc: "스킬 대상으로 지정한 아군이나 근처에 있는 아군을 보호. 자신 또는 보호받는 아군이 레벨에 비례하여 피해를 입으면 둘 다 보호막 획득.",
    longDesc:
      "자신으로부터 350유닛 내에 있는 아군이나 자신이 스킬의 대상으로 삼은 아군을 2.5초 동안 <i>보호</i>합니다. <i>보호</i>하는 중 자신과 아군 중 한 명이 <i>보호</i>의 지속시간 동안 어느 정도 피해를 입으면 둘 모두에게 1.5초 동안 보호막이 생성됩니다.<br><br>재사용 대기시간: <scaleLevel>70~40</scaleLevel>초<br>보호막 흡수량: <scaleLevel>50~130</scaleLevel>+주문력의 <scaleAP>15%</scaleAP>+추가 체력의 <scalehealth>9%</scalehealth><br>최종 기준치: 감소 후 피해량 <scaleLevel>90~250</scaleLevel>",
    iconPath: "perk-images/Styles/Resolve/Guardian/Guardian.png",
    endOfGameStatDescs: ["총 보호막 수치: @eogvar1@"],
  },
  {
    id: 8138,
    name: "사냥의 증표",
    majorChangePatchVersion: "",
    tooltip:
      "챔피언 처치에 관여하면 증표를 얻습니다. 증표 하나당 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 1.2 또는 추가 주문력 2의 효과를 얻습니다. <br><br>증표 개수가 최대치인 10개에 도달하면 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 6 또는 추가 주문력 10의 효과를 부가적으로 획득합니다.<br><br>적 챔피언 처치 관여 시마다 증표 1개를 얻습니다.<br><hr><br>획득한 능력치: <scaleAD>+공격력 @f2@</scaleAD><br>증표: @f3@/10",
    shortDesc:
      "챔피언 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>처치 관여</lol-uikit-tooltipped-keyword> 시마다 증표 획득. 개당 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'>적응형</lol-uikit-tooltipped-keyword>으로 공격력 또는 주문력 영구 증가 및 최대 개수 도달 시 추가 증가",
    longDesc:
      "챔피언 처치에 관여하면 증표를 얻습니다. 증표 하나당 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 1.2 또는 추가 주문력 2의 효과를 얻습니다. <br><br>증표 개수가 최대치인 10개에 도달하면 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 6 또는 추가 주문력 10의 효과를 부가적으로 획득합니다.<br><br>적 챔피언 처치 관여 시마다 증표 1개를 얻습니다.",
    iconPath: "perk-images/Styles/Domination/EyeballCollection/EyeballCollection.png",
    endOfGameStatDescs: ["총 추가 공격력/주문력: @eogvar1@"],
  },
  {
    id: 8127,
    name: "뒤틀린 외과의",
    majorChangePatchVersion: "",
    tooltip:
      "<pathDomination>지배</pathDomination> + <pathPrecision>정밀</pathPrecision><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD><br>공격 속도 +0%",
    shortDesc: "<pathBonus><pathDomination>지배</pathDomination> + <pathPrecision>정밀</pathPrecision> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>공격 속도 +0%",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8143,
    name: "돌발 일격",
    majorChangePatchVersion: "",
    tooltip:
      "돌진, 도약, 점멸, 순간이동을 사용하거나 은신에서 빠져나온 뒤 적 챔피언에게 피해를 주면 5초 동안 7의 물리 관통력과 6의 마법 관통력을 얻습니다.<br><br>재사용 대기시간: 4초<br><hr><br>챔피언 대상 추가 피해량: @f1@",
    shortDesc: "돌진, 도약, 점멸, 순간이동을 사용하거나 은신에서 빠져나오면 물리 관통력 및 마법 관통력 급증",
    longDesc: "돌진, 도약, 점멸, 순간이동을 사용하거나 은신에서 빠져나온 뒤 적 챔피언에게 피해를 주면 5초 동안 7의 물리 관통력과 6의 마법 관통력을 얻습니다.<br><br>재사용 대기시간: 4초",
    iconPath: "perk-images/Styles/Domination/SuddenImpact/SuddenImpact.png",
    endOfGameStatDescs: ["추가 피해량: @eogvar1@"],
  },
  {
    id: 8345,
    name: "비스킷 배달",
    majorChangePatchVersion: "",
    tooltip:
      "비스킷 배달: 6분까지 2분마다 굳건한 의지의 완전한 비스킷 아이템을 얻습니다.<br><br>비스킷을 사용하면 잃은 체력과 마나의 10%를 회복합니다. 비스킷 하나를 사용하거나 판매하면 최대 마나가 영구적으로 50만큼 늘어납니다. <br><br><i>마나 없음:</i> 마나가 없는 챔피언은 마나 대신 잃은 체력의 12%를 회복합니다.<br><hr><br>비스킷 획득: @f1@/@f2@",
    shortDesc: "게임 시작 후 6분까지 2분마다 비스킷 1개 획득. 비스킷 사용 또는 판매 시 체력/마나 회복 및 최대 마나 영구 증가",
    longDesc:
      "비스킷 배달: 6분까지 2분마다 굳건한 의지의 완전한 비스킷 아이템을 얻습니다.<br><br>비스킷을 사용하면 잃은 체력과 마나의 10%를 회복합니다. 비스킷 하나를 사용하거나 판매하면 최대 마나가 영구적으로 50만큼 늘어납니다. <br><br><i>마나 없음:</i> 마나가 없는 챔피언은 마나 대신 잃은 체력의 12%를 회복합니다.",
    iconPath: "perk-images/Styles/Inspiration/BiscuitDelivery/BiscuitDelivery.png",
    endOfGameStatDescs: ["획득한 비스킷: @eogvar1@"],
  },
  {
    id: 8444,
    name: "재생의 바람",
    majorChangePatchVersion: "",
    tooltip: "적 챔피언에게 피해를 입으면 10초 동안 잃은 체력의 4% + 6만큼 회복합니다.<br><hr><br><scaleAD>총 체력 회복량: @f1@</scaleAD>",
    shortDesc: "적 챔피언에게 피해를 입으면 일정 시간에 걸쳐 잃은 체력의 일부 회복 ",
    longDesc: "적 챔피언에게 피해를 입으면 10초 동안 잃은 체력의 4% + 6만큼 회복합니다.",
    iconPath: "perk-images/Styles/Resolve/SecondWind/SecondWind.png",
    endOfGameStatDescs: ["총 회복량: @eogvar1@"],
  },
  {
    id: 8205,
    name: "불패의 주문술사",
    majorChangePatchVersion: "",
    tooltip:
      "<pathSorcery>마법</pathSorcery> + <pathPrecision>정밀</pathPrecision><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD><br>공격 속도 +0%",
    shortDesc: "<pathBonus><pathSorcery>마법</pathSorcery> + <pathPrecision>정밀</pathPrecision> 세트 보너스</pathBonus>",
    longDesc: "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>공격 속도 +0%",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8437,
    name: "착취의 손아귀",
    majorChangePatchVersion: "",
    tooltip:
      "전투 중 4초마다 챔피언에 대한 기본 공격 시 다음 효과를 얻습니다.<li>자신 최대 체력의 4%에 해당하는 추가 마법 피해</li><li>자신 최대 체력의 2%에 해당하는 체력 회복</li><li>영구적으로 체력 5 증가</li><br><rules><i>원거리 챔피언:</i> 피해량, 회복량, 체력 영구 증가량이 40% 감소합니다.</rules><br><br><hr><br>챔피언에 대한 피해량: <scaleHealth>@f1@</scaleHealth><br>총 회복량: <scaleHealth>@f2@</scaleHealth><br>사용 횟수: @f3@",
    shortDesc: "4초마다 적 챔피언 기본 공격 시 추가 마법 피해, 체력 회복, 체력 영구 증가",
    longDesc:
      "전투 중 4초마다 챔피언에 대한 기본 공격 시 다음 효과를 얻습니다.<li>자신 최대 체력의 4%에 해당하는 추가 마법 피해</li><li>자신 최대 체력의 2%에 해당하는 체력 회복</li><li>영구적으로 체력 5 증가</li><br><rules><i>원거리 챔피언:</i> 피해량, 회복량, 체력 영구 증가량이 40% 감소합니다.</rules><br>",
    iconPath: "perk-images/Styles/Resolve/GraspOfTheUndying/GraspOfTheUndying.png",
    endOfGameStatDescs: ["총 피해량: @eogvar1@", "총 회복량: @eogvar2@"],
  },
  {
    id: 9923,
    name: "칼날비",
    majorChangePatchVersion: "8.11",
    tooltip:
      "적 챔피언에 대한 3번째 공격까지 공격 속도가 @f3@% 증가합니다. <br><br>재사용 대기시간: 12초.<br><hr><br>칼날비 공격 횟수: @f1@<br>칼날비 공격 적중률: @f2@%<br><br><rules>기본 공격 모션이 취소될 경우 공격 속도 증가 효과가 적용되는 공격 횟수가 1회 늘어납니다.<br>일시적으로 최고 공격 속도 제한을 초과할 수 있습니다.</rules>",
    shortDesc: "적 챔피언에 대한 첫 공격 3회 동안 공격 속도 대폭 증가",
    longDesc:
      "적 챔피언에 대한 3번째 공격까지 공격 속도가 110% 증가합니다.<br><br>3초 안에 다음 공격을 가하지 못하면 효과가 사라집니다.<br><br>재사용 대기시간: 12초<br><br><rules>기본 공격 모션이 취소될 경우 공격 속도 증가 효과가 적용되는 공격 횟수가 1회 늘어납니다.<br>일시적으로 최고 공격 속도 제한을 초과할 수 있습니다.</rules>",
    iconPath: "perk-images/Styles/Domination/HailOfBlades/HailOfBlades.png",
    endOfGameStatDescs: ["추가 공격 속도로 가한 공격 횟수: @eogvar1@", "칼날비 공격 적중률: @eogvar2@%"],
  },
  {
    id: 8429,
    name: "사전 준비",
    majorChangePatchVersion: "9.9",
    tooltip:
      "12분 후 방어력 +9 및 마법 저항력 +9 증가와 동시에 방어력 및 마법 저항력 5% 증가<br><br>추가 방어력: @f3@ <scaleArmor>(+@f4@)</scaleArmor><br>추가 마법 저항력: @f5@ <scaleMR>(+@f6@)</scaleMR>",
    shortDesc: "12분 후 방어력 +9 및 마법 저항력 +9 증가와 동시에 방어력 및 마법 저항력 5% 증가",
    longDesc: "12분 후 방어력 +9 및 마법 저항력 +9 증가와 동시에 방어력 및 마법 저항력 5% 증가",
    iconPath: "perk-images/Styles/Resolve/Conditioning/Conditioning.png",
    endOfGameStatDescs: ["활성화된 게임: @eogvar1@%", "총 추가 방어력: @eogvar2@", "총 추가 마법 저항력: @eogvar3@"],
  },
  {
    id: 8124,
    name: "포식자",
    majorChangePatchVersion: "",
    tooltip:
      "장화에 <font color='#c60300'>포식자</font> 사용 효과를 부여합니다.<br><br>적 챔피언을 쫓아가면 1.5초 동안 <speed>이동 속도</speed>가 <speed>45%</speed>까지 점차 증가합니다. 챔피언에게 공격 또는 스킬 사용 시 이 효과가 종료되며 <scaleLevel>@f3@</scaleLevel><font color='#99FF99'>(+@f5@)</font><font color='#FF8C00'>(+@f4@)</font>의 추가 피해를 입힙니다. <br><br>재사용 대기시간: <scaleLevel>@f7@</scaleLevel>초<br><hr><br>챔피언에게 입힌 피해량: @f1@",
    shortDesc:
      "장화에 사용 효과 추가. 사용 시 일시적으로 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_MS'>이동 속도</lol-uikit-tooltipped-keyword>가 대폭 증가하며 다음 공격 또는 스킬 사용 시 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'>적응형 피해</lol-uikit-tooltipped-keyword>",
    longDesc:
      "장화에 '<font color='#c60300'>포식자</font>' 사용 효과를 부여합니다.<br><br>적 챔피언을 쫓을 때 이동 속도가 1초 동안 60%까지 서서히 증가합니다. 이후 챔피언에게 공격 또는 스킬 사용 시 이 효과가 종료되며 40~120(+추가 공격력의 <scaleAD>0.2</scaleAD>)(+주문력의 <scaleAP>0.1</scaleAP>)의 추가 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'><font color='#48C4B7'>적응형 피해</font></lol-uikit-tooltipped-keyword>를 입힙니다.<br><br>재사용 대기시간: 90~60초",
    iconPath: "perk-images/Styles/Domination/Predator/Predator.png",
    endOfGameStatDescs: ["챔피언에게 가한 총 피해량: @eogvar1@"],
  },
  {
    id: 8233,
    name: "절대 집중",
    majorChangePatchVersion: "",
    tooltip:
      "체력이 70% 이상일 경우 레벨에 따라 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 최대 18 또는 추가 주문력 최대 30의 효과를 얻습니다. <br><br>1레벨에 1.8의 공격력 또는 3의 주문력을 얻습니다. <br><hr><br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD>",
    shortDesc: "체력이 70% 이상일 경우 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'>적응형 피해</lol-uikit-tooltipped-keyword> 추가 적용",
    longDesc:
      "체력이 70% 이상일 경우 레벨에 따라 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 최대 18 또는 추가 주문력 최대 30의 효과를 얻습니다. <br><br>1레벨에 1.8의 공격력 또는 3의 주문력을 얻습니다. ",
    iconPath: "perk-images/Styles/Sorcery/AbsoluteFocus/AbsoluteFocus.png",
    endOfGameStatDescs: ["총 활성화 시간: @eogvar1@:@eogvar2@"],
  },
  {
    id: 8007,
    name: "지적초월자",
    majorChangePatchVersion: "",
    tooltip: "<pathPrecision>정밀</pathPrecision> + <pathInspiration>영감</pathInspiration><br>공격 속도 +0%",
    shortDesc: "<pathBonus><pathPrecision>정밀</pathPrecision> + <pathInspiration>영감</pathInspiration> 세트 보너스</pathBonus>",
    longDesc: "공격 속도 +0%",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8136,
    name: "좀비 와드",
    majorChangePatchVersion: "8.14",
    tooltip:
      "적 와드 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>파괴 관여</lol-uikit-tooltipped-keyword> 시 그 자리에 아군 좀비 와드가 생성됩니다.<br><br>좀비 와드가 생성될 때마다 최대 10회까지 중첩되는 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 1.2 또는 추가 주문력 2의 효과를 얻습니다. <br><br>좀비 와드를 10개 생성하면 10의 적응형 능력치를 부가적으로 획득합니다.<br><br>좀비 와드는 적이 볼 수 있고 120초 동안 유지되며, 설치 가능 와드 수에 영향을 주지 않습니다.<br><hr><br>획득한 능력치: <scaleAD>+공격력 @f2@</scaleAD><br>생성된 좀비 와드 수: @f1@",
    shortDesc:
      "적 와드 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>파괴 관여</lol-uikit-tooltipped-keyword> 시 그 자리에 아군 좀비 와드 생성. 생성된 좀비 와드 하나당 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'>적응형</lol-uikit-tooltipped-keyword>으로 공격력 또는 주문력 영구 증가 및 최대 개수 도달 시 추가로 증가",
    longDesc:
      "적 와드 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Takedown'>파괴 관여</lol-uikit-tooltipped-keyword> 시 그 자리에 아군 좀비 와드가 생성됩니다.<br><br>좀비 와드가 생성될 때마다 최대 10회까지 중첩되는 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 1.2 또는 추가 주문력 2의 효과를 얻습니다. <br><br>좀비 와드를 10개 생성하면 10의 적응형 능력치를 부가적으로 획득합니다.<br><br>좀비 와드는 적이 볼 수 있고 120초 동안 유지되며, 설치 가능 와드 수에 영향을 주지 않습니다.",
    iconPath: "perk-images/Styles/Domination/ZombieWard/ZombieWard.png",
    endOfGameStatDescs: ["생성된 와드 수: @eogvar1@", "적응형 능력치 획득량: @eogvar2@"],
  },
  {
    id: 8358,
    name: "프로토타입: 만능의 돌",
    majorChangePatchVersion: "9.23",
    tooltip:
      "주기적으로 다른 무작위 핵심 룬을 1회 사용할 수 있습니다.<br><br>핵심 룬을 사용하고 @Cooldown@초가 지나야 다음 핵심 룬을 사용할 수 있습니다. (원거리 챔피언의 경우 @CooldownRanged@초)<br><br><rules><br>준비된 핵심 룬을 40초 동안 사용하지 않으면 적 챔피언과의 전투에서 벗어날 때 새로운 핵심 룬이 준비됩니다.<br>여진은 여진을 발동할 수 있는 기본 스킬을 배운 챔피언만 사용할 수 있습니다.<br>포식자는 이미 장화를 구매한 챔피언만 사용할 수 있습니다.<br>어둠의 수확으로 수확한 영혼은 모든 핵심 룬을 강화합니다. (영혼 @f4@개 수확)<br></rules><br><hr><br>사용한 핵심 룬: @f1@<br>적에게 입힌 총 피해량: @f2@<br>적용된 이로운 효과: @f3@",
    shortDesc: "주기적으로 다른 무작위 핵심 룬을 1회 사용할 수 있습니다.",
    longDesc:
      "주기적으로 다른 무작위 핵심 룬을 1회 사용할 수 있습니다.<br><br>핵심 룬을 사용하고 5~3초가 지나야 다음 핵심 룬을 사용할 수 있습니다. (원거리 챔피언의 경우 9~7초)<br><br><rules><br>준비된 핵심 룬을 40초 동안 사용하지 않으면 적 챔피언과의 전투에서 벗어날 때 새로운 핵심 룬이 준비됩니다.<br>여진은 여진을 발동할 수 있는 기본 스킬을 배운 챔피언만 사용할 수 있습니다.<br>포식자는 이미 장화를 구매한 챔피언만 사용할 수 있습니다.<br></rules>",
    iconPath: "perk-images/Styles/Inspiration/MasterKey/MasterKey.png",
    endOfGameStatDescs: ["사용한 핵심 룬: @eogvar1@", "적에게 입힌 피해량: @eogvar2@", "획득한 이로운 효과: @eogvar3@개"],
  },
  {
    id: 8208,
    name: "고대의 존재",
    majorChangePatchVersion: "",
    tooltip:
      "<pathSorcery>마법</pathSorcery> + <pathResolve>결의</pathResolve><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>현재 보너스: <scaleAD><scaleAD>공격력</scaleAD> +@f1@</scaleAD><br>체력 +0 ~ 0 (레벨에 비례)",
    shortDesc: "<pathBonus><pathSorcery>마법</pathSorcery> + <pathResolve>결의</pathResolve> 세트 보너스</pathBonus>",
    longDesc:
      "<lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 공격력 +0 또는 주문력 +0<br>체력 +0 ~ 0 (레벨에 비례)",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8347,
    name: "우주적 통찰력",
    majorChangePatchVersion: "",
    tooltip: "소환사 주문 가속 +<attention>18</attention><br>아이템 가속 +<attention>10</attention>",
    shortDesc: "소환사 주문 가속 +<attention>18</attention><br>아이템 가속 +<attention>10</attention>",
    longDesc: "소환사 주문 가속 +<attention>18</attention><br>아이템 가속 +<attention>10</attention>",
    iconPath: "perk-images/Styles/Inspiration/CosmicInsight/CosmicInsight.png",
    endOfGameStatDescs: ["--"],
  },
  {
    id: 8472,
    name: "번데기",
    majorChangePatchVersion: "8.6",
    tooltip:
      "게임 시작 시 체력이 추가로 40만큼 증가합니다. 챔피언 처치에 4회 관여하면 해당 체력을 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 6 또는 추가 주문력 10의 적응형 능력치로 전환합니다.<br><hr><br>처치 관여: @f1@/@f2@<br>체력 증가량: @f3@<br>추가 <scaleAD>공격력</scaleAD> 증가량: @f4@",
    shortDesc:
      "게임 시작 시 체력이 추가로 40만큼 증가합니다. 챔피언 처치에 4회 관여하면 해당 체력을 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 6 또는 추가 주문력 10의 적응형 능력치로 전환합니다.",
    longDesc:
      "게임 시작 시 체력이 추가로 40만큼 증가합니다. 챔피언 처치에 4회 관여하면 해당 체력을 <lol-uikit-tooltipped-keyword key='LinkTooltip_Description_Adaptive'><font color='#48C4B7'>적응형</font></lol-uikit-tooltipped-keyword>으로 추가 공격력 6 또는 추가 주문력 10의 적응형 능력치로 전환합니다.",
    iconPath: "perk-images/Styles/Resolve/Chrysalis/Chrysalis.png",
    endOfGameStatDescs: [],
  },
  {
    id: 8229,
    name: "신비로운 유성",
    majorChangePatchVersion: "",
    tooltip:
      "챔피언에게 스킬로 피해를 주면 해당 위치에 유성을 불러옵니다. 신비로운 유성이 재사용 대기 중일 경우 남은 재사용 대기시간이 감소합니다.<br><rules><br>재사용 대기시간 감소:<br>단일 대상 스킬: 20%<br>광역 스킬: 10%<br>지속 피해 스킬: 5%<br></rules><br>피해량: <font color='#FFFFFF'>@f5@</font> (+<scaleAP>@f6@</scaleAP>) (+<scaleAD>@f7@</scaleAD>)<br>재사용 대기시간: @f2@초<br><hr><br>소환한 유성의 @f3@%를 적중시키고 적 챔피언에게 총 @f1@의 피해를 가했습니다.",
    shortDesc: "챔피언에게 스킬로 피해를 주면 해당 위치에 피해를 가하는 유성 소환",
    longDesc:
      "챔피언에게 스킬로 피해를 주면 해당 위치에 유성을 불러옵니다. 신비로운 유성이 재사용 대기 중일 경우 남은 재사용 대기시간이 감소합니다.<br><br><lol-uikit-tooltipped-keyword key='LinkTooltip_Description_AdaptiveDmg'><font color='#48C4B7'>적응형 피해</font></lol-uikit-tooltipped-keyword>: 레벨에 따라 30 ~ 100 (<scaleAP>+주문력의 0.2</scaleAP> 및 <scaleAD>+추가 공격력의 0.35</scaleAD>)<br>재사용 대기시간: 20 ~ 8초<br><rules><br>재사용 대기시간 감소:<br>단일 대상 스킬: 20%<br>광역 스킬: 10%<br>지속 피해 스킬: 5%<br></rules>",
    iconPath: "perk-images/Styles/Sorcery/ArcaneComet/ArcaneComet.png",
    endOfGameStatDescs: ["적에게 입힌 총 피해량: @eogvar1@"],
  },
  {
    id: 8344,
    name: "우아한 결투가 ",
    majorChangePatchVersion: "",
    tooltip: "<pathInspiration>영감</pathInspiration> + <pathPrecision>정밀</pathPrecision><br>공격 속도 +0%",
    shortDesc: "<pathBonus><pathInspiration>영감</pathInspiration> + <pathPrecision>정밀</pathPrecision> 세트 보너스</pathBonus>",
    longDesc: "공격 속도 +0%",
    iconPath: "perk-images/Styles/RunesIcon.png",
    endOfGameStatDescs: [],
  },
  {
    id: 9101,
    name: "과다치유",
    majorChangePatchVersion: "",
    tooltip:
      "자신에 대한 체력 회복 초과분이 보호막으로 전환됩니다. 보호막은 <scaleHealth>최대 체력의 @f7@</scaleHealth>에 해당하는 피해까지 흡수할 수 있습니다.<br><br>보호막 전환율은 자신 또는 아군으로부터의 체력 회복 초과분의 <scaleLevel>@f6@%</scaleLevel>입니다.<br><hr><br><b>총 피해 흡수량: <scaleAD>@f1@</scaleAD></b>",
    shortDesc: "자신의 체력을 초과한 체력 회복 효과가 보호막으로 전환",
    longDesc:
      "자신에 대한 체력 회복 초과분이 보호막으로 전환됩니다. 보호막은 10<scaleHealth>(+최대 체력의 10%)</scaleHealth>에 해당하는 피해까지 흡수할 수 있습니다.<br><br>보호막 전환율은 자신 또는 아군으로부터의 체력 회복 초과분의 20~100%입니다.",
    iconPath: "perk-images/Styles/Precision/Overheal.png",
    endOfGameStatDescs: ["총 보호막 흡수량: @eogvar2@"],
  },
];
