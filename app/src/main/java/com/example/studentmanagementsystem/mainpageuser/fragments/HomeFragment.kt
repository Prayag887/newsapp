import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.studentmanagementsystem.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class HomeFragment : Fragment() {

    private lateinit var barChart: BarChart
    private lateinit var pieChart: PieChart
    private lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

//        THIS IS FOR BAR GRAPH
        barChart = view.findViewById(R.id.barChart)

        // Generate the data entries for the bar graph
        val entriesBarGraph = listOf(
            BarEntry(1f, 3232.85f),
            BarEntry(2f, 5551.74f),
            BarEntry(3f, 2100.08f),
            BarEntry(4f, 1931.52f)
        )

        // Create a list of custom colors
        val colorsBarGraph = listOf(
            ContextCompat.getColor(requireContext(), R.color.corn),
            ContextCompat.getColor(requireContext(), R.color.paddy),
            ContextCompat.getColor(requireContext(), R.color.wheat),
            ContextCompat.getColor(requireContext(), R.color.rice)
        )

        // Create the dataset and customize its appearance
        val dataSetBarGraph = BarDataSet(entriesBarGraph, "Bar Graph")
        dataSetBarGraph.colors = colorsBarGraph

        // Create the BarData object and set it to the chart
        val barData = BarData(dataSetBarGraph)
        barChart.data = barData

        // Configure chart settings
        barChart.setDrawValueAboveBar(true)
        barChart.description.isEnabled = false
        barChart.legend.isEnabled = true


        barChart.legend.textColor = Color.WHITE
        barChart.animateY(1000)

        // Customize x-axis appearance
        val xAxis = barChart.xAxis
        xAxis.setDrawGridLines(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setCenterAxisLabels(false)
//        xAxis.valueFormatter = IndexAxisValueFormatter(arrayOf("Rice", "Wheat", "Paddy", "Corn"))
        xAxis.textColor = R.color.cardview

        // Customize y-axis appearance
        val yAxisLeft = barChart.axisLeft
        yAxisLeft.setDrawGridLines(false)
        yAxisLeft.textColor = Color.WHITE

        val yAxisRight = barChart.axisRight
        yAxisRight.setDrawGridLines(false)
        yAxisRight.textColor = Color.WHITE

        // Enable value labels for the bars
        dataSetBarGraph.setDrawValues(true)
        dataSetBarGraph.valueTextColor = Color.WHITE
        dataSetBarGraph.valueTextSize = 12f

        // Adjust the bar width
        barData.barWidth = 0.7f // Adjust the bar width here (0.4f is just an example)

        val legendEntries = arrayOf(
            LegendEntry("Corn", Legend.LegendForm.DEFAULT, 8f, 8f, null, colorsBarGraph[0]),
            LegendEntry("Paddy", Legend.LegendForm.DEFAULT, 8f, 8f, null, colorsBarGraph[1]),
            LegendEntry("Wheat", Legend.LegendForm.DEFAULT, 8f, 8f, null, colorsBarGraph[2]),
            LegendEntry("Pulses", Legend.LegendForm.DEFAULT, 8f, 8f, null, colorsBarGraph[3])
        )

        // Set custom legend entries
        barChart.legend.setCustom(legendEntries)






//        THIS IS FOR PIE CHART

        pieChart = view.findViewById(R.id.pieChart)

        // Generate the data entries for the pie chart
        val entries = listOf(
            PieEntry(3232.85f, "Corn"),
            PieEntry(5551.74f, "Paddy"),
            PieEntry(2100.08f, "Wheat"),
            PieEntry(1931.52f, "Pulses")
        )

        val colors = listOf(
            ContextCompat.getColor(requireContext(), R.color.corn),
            ContextCompat.getColor(requireContext(), R.color.paddy),
            ContextCompat.getColor(requireContext(), R.color.wheat),
            ContextCompat.getColor(requireContext(), R.color.rice)
        )
        // Create the dataset and customize its appearance
        val dataSet = PieDataSet(entries, "Rice Production")
        dataSet.colors = colors

        // Create the PieData object and set it to the chart
        val pieData = PieData(dataSet)
        pieChart.data = pieData

        // Configure chart settings
        pieChart.description.isEnabled = true
        pieChart.description.text = "in Percentage"
        pieChart.description.textColor = ContextCompat.getColor(requireContext(), R.color.teal_200)
        pieChart.description.isEnabled = true
        pieChart.legend.isEnabled = false
        pieChart.animateXY(1000, 1000)

        // Customize label appearance
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.setEntryLabelTextSize(14f)

        // Customize value appearance
        pieChart.setUsePercentValues(true)
        pieChart.setDrawEntryLabels(true)
        pieData.setValueTextSize(12f)
        pieData.setValueTextColor(Color.BLACK)







//        LINE GRAPH

        lineChart = view.findViewById(R.id.lineChart)

        // Create data entries for rice, paddy, wheat, and corn production

        val cornEntries = listOf(
            Entry(1f, 2.96f),
            Entry(2f, 2.77f),
            Entry(3f, 1.9f),
            Entry(4f, 1.39f),
            Entry(5f, 3.23f)
        )

        val paddyEntries = listOf(
            Entry(1f, 5f),
            Entry(2f, 5.15f),
            Entry(3f, 5.06f),
            Entry(4f, 4.2f),
            Entry(5f, 6f)
        )

        val wheatEntries = listOf(
            Entry(1f, 2.81f),
            Entry(2f, 2.44f),
            Entry(3f, 2.15f),
            Entry(4f, 2.73f),
            Entry(5f, 2.72f)
        )

        val pulsesEntries = listOf(
            Entry(1f, 1.15f),
            Entry(2f, 2.11f),
            Entry(3f, 1.55f),
            Entry(4f, 1.93f),
            Entry(5f, 1.48f)
        )

        lineChart.setExtraOffsets(0f, 0f, 0f, 16f)

        // Create dataset for rice production
        val dataSetRice = LineDataSet(pulsesEntries, "Rice")
        dataSetRice.color = ContextCompat.getColor(requireContext(), R.color.rice)

        // Create dataset for paddy production
        val dataSetPaddy = LineDataSet(paddyEntries, "Paddy")
        dataSetPaddy.color = ContextCompat.getColor(requireContext(), R.color.paddy)

        // Create dataset for wheat production
        val dataSetWheat = LineDataSet(wheatEntries, "Wheat")
        dataSetWheat.color = ContextCompat.getColor(requireContext(), R.color.wheat)

        // Create dataset for corn production
        val dataSetCorn = LineDataSet(cornEntries, "Corn")
        dataSetCorn.color = ContextCompat.getColor(requireContext(), R.color.corn)

        // Set the line width for each dataset
        dataSetRice.lineWidth = 2f
        dataSetPaddy.lineWidth = 2f
        dataSetWheat.lineWidth = 2f
        dataSetCorn.lineWidth = 2f

        // Combine all datasets into a single LineData object
        val lineData = LineData(dataSetRice, dataSetPaddy, dataSetWheat, dataSetCorn)

        // Configure chart settings
        lineChart.data = lineData
        lineChart.description = Description().apply {
            text = "Production Over Last 5 Years"
            textColor = Color.WHITE
        }
        lineChart.legend.textColor = Color.WHITE
        lineChart.xAxis.textColor = Color.WHITE
        lineChart.axisLeft.textColor = Color.WHITE
        lineChart.axisRight.textColor = Color.WHITE

        // Customize X-axis labels
        val xAxisLineGraph = lineChart.xAxis
        xAxisLineGraph.valueFormatter = IndexAxisValueFormatter(arrayOf("", "2017", "2018", "2019", "2020", "2021"))
        xAxisLineGraph.position = XAxis.XAxisPosition.BOTTOM
        xAxisLineGraph.setDrawGridLines(false)
        xAxisLineGraph.granularity = 1f

        // Customize Y-axis labels
        val yAxisLeftLineGraph = lineChart.axisLeft
        yAxisLeftLineGraph.setDrawGridLines(true)
        yAxisLeftLineGraph.gridColor = ContextCompat.getColor(requireContext(), R.color.teal_200)
        yAxisLeftLineGraph.axisMinimum = 0f

        val yAxisRightLineGraph = lineChart.axisRight
        yAxisRightLineGraph.setDrawGridLines(false)
        yAxisRightLineGraph.axisMinimum = 0f

        lineChart.animateX(1000)

        // Refresh the chart
        lineChart.invalidate()

        return view
    }
}
