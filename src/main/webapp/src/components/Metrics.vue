<template>
    <v-container>
        <v-row>
            <v-col cols="4">
                <v-sheet elevation="5" height="200" color="white" rounded class="mx-auto">

                    <v-row class="fill-height" align="center" justify="center">
                        <v-col cols="8" style="border-right:2px solid black" class="text-h2 font-weight-black">WIP</v-col>
                        <v-col cols="4" class="text-h1 blue--text">5</v-col>
                    </v-row>
                </v-sheet>
            </v-col>
            <v-col cols="4">
                <v-sheet elevation="5" height="200" color="white" rounded class="mx-auto">

                    <v-row class="fill-height" align="center" justify="center">
                        <v-col cols="8" style="border-right:2px solid black" class="text-h2 font-weight-black">Cycle Time</v-col>
                        <v-col cols="4" class="text-h1 blue--text">3</v-col>
                    </v-row>
                </v-sheet>
            </v-col>
            <v-col cols="4">
                <v-sheet elevation="5" height="200" color="white" rounded class="mx-auto">

                    <v-row class="fill-height" align="center" justify="center">
                        <v-col cols="8" style="border-right:2px solid black" class="text-h2 font-weight-black">Throughput</v-col>
                        <v-col cols="4" class="text-h1 blue--text">12</v-col>
                    </v-row>
                </v-sheet>
            </v-col>
        </v-row>
        <v-row>
            <div id="chart-container">
                <apexchart type="scatter" height="350" :options="chartOptions" :series="series"></apexchart>
            </div>
        </v-row>
    </v-container>
</template>

<script>

  function generateDayWiseTimeSeries(baseval, count, yrange) {
    var i = 0;
    var series = [];
    while (i < count) {
      var y = Math.floor(Math.random() * (yrange.max - yrange.min + 1)) + yrange.min;

      series.push([baseval, y]);
      baseval += 86400000;
      i++;
    }
    return series;
  }

  function generate90(baseval, count, yrange) {
      var i = 0;
      var series = [];
      while (i < count) {
        var y = 45;

        series.push([baseval, y]);
        baseval += 86400000;
        i++;
      }
      return series;
  }

  export default {
    data: () => ({
        series: [{
                  name: 'CT by week',
                  type: 'scatter',
                  data: generateDayWiseTimeSeries(new Date('29 Mar 2021 GMT').getTime(), 100, {
                    min: 10,
                    max: 60
                  })
                },
                {
                  name: '85 %',
                  type: 'line',
                  data: generate90(new Date('29 Mar 2021 GMT').getTime(), 100, {
                    min: 10,
                    max: 60
                  })
                },
              ],
        chartOptions: {
            chart: {
              height: 350,
               toolbar: {
                  show: false
               }
            },
            title: {
                text: 'Cycle Time Scatterplot'
            },
            dataLabels: {
              enabled: false
            },
            yaxis: [
                {
                  axisTicks: {
                    show: true
                  },
                  axisBorder: {
                    show: true,
                    color: "#FF1654"
                  },
                  labels: {
                    style: {
                      colors: "#FF1654"
                    }
                  },
                  title: {
                    text: "Series A",
                    style: {
                      color: "#FF1654"
                    }
                  }
                },
                {
                  opposite: true,
                  axisTicks: {
                    show: true
                  },
                  axisBorder: {
                    show: true,
                    color: "#247BA0"
                  },
                  labels: {
                    style: {
                      colors: "#247BA0"
                    }
                  },
                  title: {
                    text: "Series B",
                    style: {
                      color: "#247BA0"
                    }
                  }
                }
              ],
            grid: {
              xaxis: {
                lines: {
                  show: true
                }
              },
              yaxis: {
                lines: {
                  show: true
                }
              },
            },
            xaxis: {
              type: 'datetime',
            },
            yaxis: {
              max: 70
            }
        },
    })
  }

</script>