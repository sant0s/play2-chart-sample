package controllers;

import java.util.Map;

import name.josesantos.play.chart.BarChartBuilder;
import name.josesantos.play.chart.Chart;
import name.josesantos.play.chart.ChartBuilderFactory;
import name.josesantos.play.chart.ChartOrientation;
import name.josesantos.play.chart.ChartResults;
import name.josesantos.play.chart.LineChartBuilder;
import name.josesantos.play.chart.PieChartBuilder;
import name.josesantos.play.chart.RingChartBuilder;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.collect.ImmutableMap;

/**
 * Chart module demo application.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class Application extends Controller {

    /**
     * Series (recipes) and categories (ingredients) dataset.
     */
    private static final Map<Comparable<?>, Map<Comparable<?>, Number>> SERIES_CATEGORIES_VALUES = ImmutableMap.of(
	    "Apple Pie",
	    ImmutableMap.<Comparable<?>, Number> builder().put("Allspice", 0).put("Apple", 70).put("Cinnamon", 5)
		    .put("Flour", 15).put("Pumpkin", 0).put("Sugar", 10).build(),

	    "Pumpkin Pie",
	    ImmutableMap.<Comparable<?>, Number> builder().put("Allspice", 5).put("Apple", 0).put("Cinnamon", 0)
		    .put("Flour", 15).put("Pumpkin", 65).put("Sugar", 15).build());

    /**
     * Keys (continents) and values (area) dataset.
     */
    private static final Map<Comparable<?>, Number> KEYS_VALUES = ImmutableMap.<Comparable<?>, Number> builder()
	    .put("Asia", 29.5D).put("Africa", 20.4D).put("North America", 16.5D).put("South America", 12D)
	    .put("Antarctica", 9.2D).put("Europe", 6.8D).put("Australia", 5.9D).build();

    public static Result index() {

	// BAR CHARTS

	// bar chart with a dataset of series of categories and values
	BarChartBuilder barChart1Builder = ChartBuilderFactory.newBarChartBuilder(SERIES_CATEGORIES_VALUES);
	Chart barChart1 = barChart1Builder.build();

	// same dataset as previous one but customised
	BarChartBuilder barChart2Builder = ChartBuilderFactory.newBarChartBuilder(SERIES_CATEGORIES_VALUES);
	barChart2Builder.title("Chart 2").titleFontSize(20).legend(true).width(700).height(500).xLabel("Ingredients")
		.yLabel("Quantity").orientation(ChartOrientation.HORIZONTAL);
	Chart barChart2 = barChart2Builder.build();

	// LINE CHARTS

	// line chart with a dataset of series of categories and values
	LineChartBuilder lineChart1Builder = ChartBuilderFactory.newLineChartBuilder(SERIES_CATEGORIES_VALUES);
	Chart lineChart1 = lineChart1Builder.build();

	// same dataset as previous one but customised
	LineChartBuilder lineChart2Builder = ChartBuilderFactory.newLineChartBuilder(SERIES_CATEGORIES_VALUES);
	lineChart2Builder.title("Chart 2").titleFontSize(20).legend(true).width(700).height(500).xLabel("Ingredients")
		.yLabel("Quantity").orientation(ChartOrientation.HORIZONTAL);
	Chart lineChart2 = lineChart2Builder.build();

	// PIE CHARTS

	// dataset of categories and values
	PieChartBuilder pieChart1Builder = ChartBuilderFactory.newPieChartBuilder(KEYS_VALUES);
	Chart pieChart1 = pieChart1Builder.build();

	// same as previous one but customised
	PieChartBuilder pieChart2Builder = ChartBuilderFactory.newPieChartBuilder(KEYS_VALUES);
	pieChart2Builder.title("Pie 2").titleFontSize(20).legend(true).width(700).height(500);
	Chart pieChart2 = pieChart2Builder.build();

	// RING CHARTS

	// dataset of categories and values
	RingChartBuilder ringChart1Builder = ChartBuilderFactory.newRingChartBuilder(KEYS_VALUES);
	Chart ringChart1 = ringChart1Builder.build();

	// same as previous one but customised
	RingChartBuilder ringChart2Builder = ChartBuilderFactory.newRingChartBuilder(KEYS_VALUES);
	ringChart2Builder.title("Ring 2").titleFontSize(20).legend(true).width(700).height(500);
	Chart ringChart2 = ringChart2Builder.build();

	return ok(views.html.index.render(barChart1, barChart2, lineChart1, lineChart2, pieChart1, pieChart2,
		ringChart1, ringChart2));

    }

    public static Result chart() {

	// bar chart with a dataset of series of categories and values
	BarChartBuilder builder = ChartBuilderFactory.newBarChartBuilder(SERIES_CATEGORIES_VALUES);
	Chart chart = builder.build();

	return ChartResults.ok(chart);

    }

}