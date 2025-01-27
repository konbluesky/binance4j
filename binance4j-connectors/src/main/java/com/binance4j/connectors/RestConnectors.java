package com.binance4j.connectors;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.c2c.client.C2CClient;
import com.binance4j.convert.client.ConvertClient;
import com.binance4j.core.client.RestClient;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.futures.client.UFuturesMarketClient;
import com.binance4j.loan.client.LoanClient;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.market.client.MarketClient;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.pay.client.PayClient;
import com.binance4j.portfoliomargin.client.PortfolioMarginClient;
import com.binance4j.rebate.client.RebateClient;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.vision.client.VisionSpotClient;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.websocket.client.UserDataClient;

/** REST Connectors container. */
public class RestConnectors {
	/** The API key */
	protected String key;
	/** The API secret */
	protected String secret;

	/** Inner {@link BLVTClient}. */
	protected BLVTClient blvtClient;
	/** Inner {@link C2CClient}. */
	protected C2CClient c2cClient;
	/** Inner {@link ConvertClient}. */
	protected ConvertClient convertClient;
	/** Inner {@link FiatClient}. */
	protected FiatClient fiatClient;
	/** Inner {@link LoanClient}. */
	protected LoanClient loanClient;
	/** Inner {@link MarginClient}. */
	protected MarginClient marginClient;
	/** Inner {@link MarketClient}. */
	protected MarketClient marketClient;
	/** Inner {@link MiningClient}. */
	protected MiningClient miningClient;
	/** Inner {@link NFTClient}. */
	protected NFTClient nftClient;
	/** Inner {@link PayClient}. */
	protected PayClient payClient;
	/** Inner {@link PortfolioMarginClient}. */
	protected PortfolioMarginClient portfolioMarginClient;
	/** Inner {@link RebateClient}. */
	protected RebateClient rebateClient;
	/** Inner {@link SavingsClient}. */
	protected SavingsClient savingsClient;
	/** Inner {@link SpotClient}. */
	protected SpotClient spotClient;
	/** Inner {@link StakingClient}. */
	protected StakingClient stakingClient;
	/** Inner {@link VisionSpotClient}. */
	protected VisionSpotClient visionSpotClient;
	/** Inner {@link WalletClient}. */
	protected WalletClient walletClient;
	/** Inner {@link WalletClient}. */
	protected UserDataClient userDataClient;
	/** Inner {@link UFuturesMarketClient} */
	protected UFuturesMarketClient uFuturesMarketClient;

	/**
	 * @param key    API key
	 * @param secret API secret
	 */
	public RestConnectors(String key, String secret) {
		this.key = key;
		this.secret = secret;
	}

	/**
	 * Will update the client's keys if they have changed in the container.
	 *
	 * @param client
	 */
	private void updateClientKeys(RestClient<?> client) {
		if (!client.getKey().equals(key) || !client.getSecret().equals(secret)) {
			client.updateKeys(key, secret);
		}
	}

	/**
	 * Lazy loads and returns a cached instance of {@link BLVTClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link BLVTClient}.
	 */
	@Deprecated
	public BLVTClient blvtClient() {
		return blvt();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link FiatClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link FiatClient}.
	 */
	@Deprecated
	public C2CClient c2cClient() {
		return c2c();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link convertClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link convertClient}.
	 */
	@Deprecated
	public ConvertClient convertClient() {
		return convert();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link FiatClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link FiatClient}.
	 */
	@Deprecated
	public FiatClient fiatClient() {
		return fiat();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link LoanClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link LoanClient}.
	 */
	@Deprecated
	public LoanClient loanClient() {
		return loan();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link MarginClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link MarginClient}.
	 */
	@Deprecated
	public MarginClient marginClient() {
		return margin();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link MarketClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link MarketClient}.
	 */
	@Deprecated
	public MarketClient marketClient() {
		return market();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link MiningClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link MiningClient}.
	 */
	@Deprecated
	public MiningClient miningClient() {
		return mining();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link NFTClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link NFTClient}.
	 */
	@Deprecated
	public NFTClient nftClient() {
		return nft();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link PayClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link PayClient}.
	 */
	@Deprecated
	public PayClient payClient() {
		return pay();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link PortfolioMarginClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link PortfolioMarginClient}.
	 */
	@Deprecated
	public PortfolioMarginClient portfoliomarginClient() {
		return portfolioMargin();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link RebateClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link RebateClient}.
	 */
	@Deprecated
	public RebateClient rebateClient() {
		return rebate();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link SavingsClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link SavingsClient}.
	 */
	@Deprecated
	public SavingsClient savingsClient() {
		return savings();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link SpotClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link SpotClient}.
	 */
	@Deprecated
	public SpotClient spotClient() {
		return spot();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link StakingClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link StakingClient}.
	 */
	@Deprecated
	public StakingClient stakingClient() {
		return staking();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link VisionSpotClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link VisionSpotClient}.
	 */
	@Deprecated
	public VisionSpotClient visionSpotClient() {
		return visionSpot();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link WalletClient}.
	 *
	 * @deprecated Will be removed in a next version.
	 * @return an instance of {@link WalletClient}.
	 */
	@Deprecated
	public WalletClient walletClient() {
		return wallet();
	}

	/**
	 * Lazy loads and returns a cached instance of {@link BLVTClient}.
	 *
	 * @return an instance of {@link BLVTClient}.
	 */
	public BLVTClient blvt() {
		if (blvtClient == null) {
			blvtClient = new BLVTClient(key, secret);
		}
		updateClientKeys(blvtClient);
		return blvtClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link C2CClient}.
	 *
	 * @return an instance of {@link C2CClient}.
	 */
	public C2CClient c2c() {
		if (c2cClient == null) {
			c2cClient = new C2CClient(key, secret);
		}
		updateClientKeys(c2cClient);
		return c2cClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link convertClient}.
	 *
	 * @return an instance of {@link convertClient}.
	 */
	public ConvertClient convert() {
		if (convertClient == null) {
			convertClient = new ConvertClient(key, secret);
		}
		updateClientKeys(convertClient);
		return convertClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link FiatClient}.
	 *
	 * @return an instance of {@link FiatClient}.
	 */
	public FiatClient fiat() {
		if (fiatClient == null) {
			fiatClient = new FiatClient(key, secret);
		}
		updateClientKeys(fiatClient);
		return fiatClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link LoanClient}.
	 *
	 * @return an instance of {@link LoanClient}.
	 */
	public LoanClient loan() {
		if (loanClient == null) {
			loanClient = new LoanClient(key, secret);
		}
		updateClientKeys(loanClient);
		return loanClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link MarginClient}.
	 *
	 * @return an instance of {@link MarginClient}.
	 */
	public MarginClient margin() {
		if (marginClient == null) {
			marginClient = new MarginClient(key, secret);
		}
		updateClientKeys(marginClient);
		return marginClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link MarketClient}.
	 *
	 * @return an instance of {@link MarketClient}.
	 */
	public MarketClient market() {
		if (marketClient == null) {
			marketClient = new MarketClient(key, secret);
		}
		updateClientKeys(marketClient);
		return marketClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link MiningClient}.
	 *
	 * @return an instance of {@link MiningClient}.
	 */
	public MiningClient mining() {
		if (miningClient == null) {
			miningClient = new MiningClient(key, secret);
		}
		updateClientKeys(miningClient);
		return miningClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link NFTClient}.
	 *
	 * @return an instance of {@link NFTClient}.
	 */
	public NFTClient nft() {
		if (nftClient == null) {
			nftClient = new NFTClient(key, secret);
		}
		updateClientKeys(nftClient);
		return nftClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link PayClient}.
	 *
	 * @return an instance of {@link PayClient}.
	 */
	public PayClient pay() {
		if (payClient == null) {
			payClient = new PayClient(key, secret);
		}
		updateClientKeys(payClient);
		return payClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link PortfolioMarginClient}.
	 *
	 * @return an instance of {@link PortfolioMarginClient}.
	 */
	public PortfolioMarginClient portfolioMargin() {
		if (portfolioMarginClient == null) {
			portfolioMarginClient = new PortfolioMarginClient(key, secret);
		}
		updateClientKeys(portfolioMarginClient);
		return portfolioMarginClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link RebateClient}.
	 *
	 * @return an instance of {@link RebateClient}.
	 */
	public RebateClient rebate() {
		if (rebateClient == null) {
			rebateClient = new RebateClient(key, secret);
		}
		updateClientKeys(rebateClient);
		return rebateClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link SavingsClient}.
	 *
	 * @return an instance of {@link SavingsClient}.
	 */
	public SavingsClient savings() {
		if (savingsClient == null) {
			savingsClient = new SavingsClient(key, secret);
		}
		updateClientKeys(savingsClient);
		return savingsClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link SpotClient}.
	 *
	 * @return an instance of {@link SpotClient}.
	 */
	public SpotClient spot() {
		if (spotClient == null) {
			spotClient = new SpotClient(key, secret);
		}
		updateClientKeys(spotClient);
		return spotClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link StakingClient}.
	 *
	 * @return an instance of {@link StakingClient}.
	 */
	public StakingClient staking() {
		if (stakingClient == null) {
			stakingClient = new StakingClient(key, secret);
		}
		updateClientKeys(stakingClient);
		return stakingClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link VisionSpotClient}.
	 *
	 * @return an instance of {@link VisionSpotClient}.
	 */
	public VisionSpotClient visionSpot() {
		if (visionSpotClient == null) {
			visionSpotClient = new VisionSpotClient();
		}
		return visionSpotClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link WalletClient}.
	 *
	 * @return an instance of {@link WalletClient}.
	 */
	public WalletClient wallet() {
		if (walletClient == null) {
			walletClient = new WalletClient(key, secret);
		}
		updateClientKeys(walletClient);
		return walletClient;
	}

	/**
	 * Lazy loads and returns a cached instance of {@link UserDataClient}.
	 *
	 * @return an instance of {@link UserDataClient}.
	 */
	public UserDataClient user() {
		if (userDataClient == null) {
			userDataClient = new UserDataClient(key, secret);
		}
		updateClientKeys(userDataClient);
		return userDataClient;
	}

	public UFuturesMarketClient uFuturesMarket(){
		if(uFuturesMarketClient==null){
			uFuturesMarketClient=new UFuturesMarketClient(key,secret);
		}
		updateClientKeys(uFuturesMarketClient);
		return uFuturesMarketClient;
	}

	/**
	 * Updates the API keys.
	 *
	 * @param key    New public key.
	 * @param secret New secret key.
	 */
	public void updateKeys(String key, String secret) {
		this.key = key;
		this.secret = secret;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}
}