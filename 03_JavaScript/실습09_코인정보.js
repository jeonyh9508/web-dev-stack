/*
https://api.upbit.com/v1/market/all
{
    "market": "KRW-BTC",
    "korean_name": "비트코인",
    "english_name": "Bitcoin"
  }
*/
/*
실습 문제
const market = document.querySelector("#market");

const fetchData = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  const coinName = await response.json();
  for (let i = 0; i < coinName.length; i++) {
    if (coinName[i].market.includes("KRW")) {
      market.innerHTML += `${coinName[i].korean_name}(${coinName[i].market})</br>`;
    }
  }
};

fetchData();
*/

/*
https://api.upbit.com/v1/market/all
{
    "market": "KRW-BTC",
    "korean_name": "비트코인",
    "english_name": "Bitcoin"
  }
*/

// async function dataFetch() {}
// const dataFetch = async function() {}
const dataFetch = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  const data = await response.json();
  //   console.log(data); 확인
  /* 풀이 1)
  //   for (let i = 0; i < data.length; i++) {console.log(data[i]);  }

  data.forEach((item) => {
    // startsWith : 시작하는 단어 여부, includes : 포함 여부
    if (
      item.market.startsWith("KRW")
      // item.market.includes("KRW")
    ) {
      market.innerHTML += `<h2>${item.korean_name}(${item.market})</h2>`;
    }
    console.log(item.market, item.market.includes("KRW"));
    console.log(item.korean_name);
  });
  //   forEach + 조건문 -> filter
};*/
  // 풀이 2)
  const krwMarkets = data.filter((item) => item.market.includes("KRW"));
  /*
  let markets = "";
  krwMarkets.forEach((item) => {
    markets += item.market + ",";
  });

  console.log(markets.slice(0, -1));

    const tickerRes = await fetch(
    `https://api.upbit.com/v1/ticker?markets=${markets.slice(0, -1)}`
  );
  
*/

  // forEach + 내가 원하는 형태로 가공하고자 할 때 -> map
  const markets = krwMarkets.map((item) => item.market).join(",");
  //   console.log(markets);

  const tickerRes = await fetch(
    `https://api.upbit.com/v1/ticker?markets=${markets}`
  );

  const tickerData = await tickerRes.json();
  //   console.log(tickerData);
  krwMarkets.forEach((item) => {
    // find :
    const ticker = tickerData.find((ticker) => ticker.market === item.market);
    // console.log(ticker);
    market.innerHTML += `<h2>${item.korean_name}(${item.market})</h2>
    <p>현재가 : ${ticker.trade_price.toLocaleString()}</p>
    <p>24시간 거래량 : ${ticker.acc_trade_volume_24h.toFixed(2)}</p>
    <p>전일 대비 : ${
      ticker.change === "RISE"
        ? "상승"
        : ticker.change === "FALL"
        ? "하락"
        : "보합"
    }(${(ticker.change_rate * 100).toFixed(2)}%)</p>
    `;
  });
};
dataFetch();
// toLocaleString() : 큰 수를 3자리 단위로
// toFixed(2) : 소수점 (자리수)까지 표현 -> (2)
// https://api.upbit.com/v1/ticker?markets=KRW-BTC,BTC-ETH
// 파라미터 값 입력 markets + 필요한 정보

// qwer1234
