package EasyInvest.tools;

import EasyInvest.dal.*;
import EasyInvest.model.*;
import EasyInvest.model.DailyStockRecommendation.PositionType;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Inserter {

	public static void main(String[] args) throws SQLException, ParseException {
		// DAO instances.
		StocksDao stocksDao = StocksDao.getInstance();
		DailyStockRecommendationDao dailyDao = DailyStockRecommendationDao.getInstance();
		
		// StockRecommendation instance
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date1 = formatter.parse("2022-10-07 00:00:00");
		Date date2 = formatter.parse("2012-01-10 00:00:00");
//		
//		DailyStockRecommendation recommendation1 = new DailyStockRecommendation(1, "TSLA", date1, PositionType.Long);
//		recommendation1 = dailyDao.create(recommendation1);
//		DailyStockRecommendation recommendation2 = new DailyStockRecommendation(2, "TSLA", date2, PositionType.Long);
//		recommendation2 = dailyDao.create(recommendation2);
//		DailyStockRecommendation recommendation3 = new DailyStockRecommendation(3, "AAPL", date2, PositionType.Short);
//		recommendation3 = dailyDao.create(recommendation3);
		
		// READ all distinct ticker name
//		List<String> DistinctTickerNames = stocksDao.getDistinctTickerNames();
//		for(String ticker : DistinctTickerNames) {
//					System.out.format("Looping ticker names: %s\n", ticker);
//		}
//		
//		// Read the begin and end row of given ticker
//		List<Stocks> startAndEnd = stocksDao.getStartAndEndForTicker("TSLA");
//		for(Stocks stock : startAndEnd) {
//			System.out.format(
//					"Looping stocks: DATE:%s OPEN:%s HIGH:%s LOW:%s CLOSE:%s ADJ_CLOSE:%s VOLUME:%s CAP_RANK:%s TICKER_NAME:%s \n", 
//					stock.getDate(), stock.getOpen(), stock.getHigh(), stock.getLow(), stock.getClose(), stock.getAdjClose(), stock.getVolume(), stock.getStockCapRank(), stock.getTickerName());
//		}
		
//		// Get the return percent based on given ticker
//		Double returnPercent = stocksDao.getReturnPercentForTicker("TSLA");
//		System.out.format("The return percent based on given ticker: %s", returnPercent);
		
		
//		// Read the recommendations based on the ticker name
//		List<DailyStockRecommendation> recommendations = dailyDao.getRecommendationByTicker("TSLA");
//		for(DailyStockRecommendation recom: recommendations) {
//			System.out.format(
//					"Looping recommendations: %s %s %s %s \n",
//					recom.getDailyStockRecommendationID(), recom.getTickerName(), recom.getDate(), recom.getPosition()
//				);
//		}
		
		// Read the recommendations based on the date
		List<DailyStockRecommendation> recommendations = dailyDao.getRecommendationByDate(date2);
		for(DailyStockRecommendation recom: recommendations) {
			System.out.format(
					"Looping recommendations: %s %s %s %s \n",
					recom.getDailyStockRecommendationID(), recom.getTickerName(), recom.getDate(), recom.getPosition()
				);
		}
		
		
	}
}