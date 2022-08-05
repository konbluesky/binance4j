const javadocBase = "https://binance4j.github.io/";
const imgBase = "/img/svg/";

export type RepoList = { [key: string]: Repo };

export interface Binance4JData {
  baseUrl: string;
  groupId: string;
  repos: RepoList;
  managersList: ProjectManagerList;
}

export interface Repo {
    name: string;
    artifactId: string;
    title: string;
    javadoc: string;
    description: string;
    icon: string;
}

const core: Repo = {
    name: "core",
    artifactId: "binance4j-core",
    title: "Core",
    javadoc: javadocBase + "binance4j-core/",
    description: "The core of every connector",
    icon: imgBase + "gear.svg",
};

const blvt: Repo = {
    name: "blvt",
    artifactId: "binance4j-blvt",
    title: "BLVT",
    javadoc: javadocBase + "binance4j-blvt/",
    description: "Manage Binance Leveraged Tokens",
    icon: imgBase + "blvt.svg",
};

const portFolio: Repo = {
    name: "portfolio-margin",
    artifactId: "binance4j-portfolio-margin",
    title: "Portfolio margin",
    javadoc: javadocBase + "binance4j-portfolio-margin/",
    description: "Manage your portfolio margin account",
    icon: imgBase + "portfolio-margin.svg",
};

const c2c: Repo = {
    name: "c2c",
    artifactId: "binance4j-c2c",
    title: "C2C",
    javadoc: javadocBase + "binance4j-c2c/",
    description: "Get c2c trade history",
    icon: imgBase + "c2c.svg",
};

const convert: Repo = {
    name: "convert",
    artifactId: "binance4j-convert",
    title: "Convert",
    javadoc: javadocBase + "binance4j-convert/",
    description: "Connect to the convert endpoints",
    icon: imgBase + "convert.svg",
};

const connectors: Repo = {
    name: "connectors",
    artifactId: "binance4j-connectors",
    title: "Connectors",
    javadoc: javadocBase + "binance4j-connectors/",
    description: "All REST clients in one place",
    icon: imgBase + "connectors.svg",
};

const fiat: Repo = {
    name: "fiat",
    artifactId: "binance4j-fiat",
    title: "Fiat",
    javadoc: javadocBase + "binance4j-fiat/",
    description: "Retrieve fiat transactions",
    icon: imgBase + "fiat.svg",
};

const loan: Repo = {
    name: "loan",
    artifactId: "binance4j-loan",
    title: "Loan",
    javadoc: javadocBase + "binance4j-loan/",
    description: "Get crypto loans income history",
    icon: imgBase + "loan.svg",
};

const mining: Repo = {
    name: "mining",
    artifactId: "binance4j-mining",
    title: "Mining",
    javadoc: javadocBase + "binance4j-mining/",
    description: "Get workers/earnings data and manage hashrate resales",
    icon: imgBase + "mining.svg",
};

const pay: Repo = {
    name: "pay",
    artifactId: "binance4j-pay",
    title: "Pay",
    javadoc: javadocBase + "binance4j-pay/",
    description: "Get pay trade history",
    icon: imgBase + "pay.svg",
};

const wallet: Repo = {
    name: "wallet",
    artifactId: "binance4j-wallet",
    title: "Wallet",
    javadoc: javadocBase + "binance4j-wallet/",
    description: "Retrieve your assets balance and transaction records",
    icon: imgBase + "wallet.svg",
};

const market: Repo = {
    name: "market",
    artifactId: "binance4j-market",
    title: "Market",
    javadoc: javadocBase + "binance4j-market/",
    description: "Get infos about the crypto Market",
    icon: imgBase + "market.svg",
};

const margin: Repo = {
    name: "margin",
    artifactId: "binance4j-margin",
    title: "Margin",
    javadoc: javadocBase + "binance4j-margin/",
    description: "Borrow tokens and multiply your investment thanks to leverage effect",
    icon: imgBase + "margin.svg",
};

const rebate: Repo = {
    name: "rebate",
    artifactId: "binance4j-rebate",
    title: "Rebate",
    javadoc: javadocBase + "binance4j-rebate/",
    description: "Get Spot rebate history records",
    icon: imgBase + "rebate.svg",
};

const spot: Repo = {
    name: "spot",
    artifactId: "binance4j-spot",
    title: "Spot",
    javadoc: javadocBase + "binance4j-spot/",
    description: "Trade on the SPOT market",
    icon: imgBase + "dollar.svg",
};

const websocket: Repo = {
    name: "websocket",
    artifactId: "binance4j-websocket",
    title: "Websocket",
    javadoc: javadocBase + "binance4j-websocket/",
    description: "Get real-time data about the market",
    icon: imgBase + "websocket.svg",
};

const vision: Repo = {
    name: "vision",
    artifactId: "binance4j-vision",
    title: "Vision",
    javadoc: javadocBase + "binance4j-vision/",
    description: "Get historical market data",
    icon: imgBase + "eye.svg",
};

const staking: Repo = {
    name: "staking",
    artifactId: "binance4j-staking",
    title: "Staking",
    javadoc: javadocBase + "binance4j-staking/",
    description: "Interact with staking products",
    icon: imgBase + "staking.svg",
};

const strategy: Repo = {
    name: "strategy",
    artifactId: "binance4j-strategy",
    title: "Strategy",
    javadoc: javadocBase + "binance4j-strategy/",
    description: "Technical analysis for the Binance4j ecosystem",
    icon: imgBase + "strategy.svg",
};

const nft: Repo = {
    name: "nft",
    artifactId: "binance4j-nft",
    title: "NFT",
    javadoc: javadocBase + "binance4j-nft/",
    description: "Get NFT transaction records",
    icon: imgBase + "nft.svg",
};

const savings: Repo = {
    name: "savings",
    artifactId: "binance4j-savings",
    title: "Savings",
    javadoc: javadocBase + "binance4j-savings/",
    description: "Interact with Binance savings products",
    icon: imgBase + "savings.svg",
};

export interface ProjectManager {
    img: string;
    href: string;
    text: string;
    language: string;
    fileName: string;
    instruction: string;
}

export type ProjectManagerList = { [key: string]: ProjectManager };

const maven: ProjectManager = {
    img: "https://search.maven.org/assets/images/mvn.png",
    href: "https://maven.apache.org/",
    text: "Apache Maven",
    language: "xml",
    fileName: "pom.xml",
    instruction:
        "<dependency>\n\t<groupId>{{groupId}}</groupId>\n\t<artifactId>{{artifactId}}</artifactId>\n\t<version>{{version}}</version>\n</dependency>",
};

const gradle: ProjectManager = {
    img: "https://search.maven.org/assets/images/gradle.png",
    href: "https://gradle.org/",
    text: "Gradle Groovy DSL",
    language: "bash",
    fileName: "build.gradle",
    instruction: "implementation '{{groupId}}:{{artifactId}}:{{version}}'",
};

const managersList: ProjectManagerList = {
    maven,
    gradle,
};

const binance4j: Binance4JData = {
    baseUrl: "https://github.com/binance4j/",
    groupId: "com.binance4j",
    repos: {
        strategy,
        websocket,
        wallet,
        market,
        spot,
        margin,
        mining,
        blvt,
        c2c,
        convert,
        fiat,
        loan,
        pay,
        portFolio,
        rebate,
        staking,
        nft,
        vision,
        savings,
        connectors,
        core,
        //strategies,
    },
    managersList,
};

export default binance4j;
