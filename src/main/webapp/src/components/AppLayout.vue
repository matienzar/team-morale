<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
    >
      <v-container class="py-0 fill-height">
        <v-avatar
          class="mr-10"
          color="grey darken-1"
          size="32"
        >
            <img
             alt="Logo del equipo"
             :src="require('../assets/kyrian.png')"
            >
        </v-avatar>

        <v-btn
          v-for="link in links"
          :key="link"
          text
        >
          {{ link }}
        </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="300">
            <v-btn
              icon
              color="blue"
            >
              <v-icon>mdi-arrow-left-bold-circle-outline</v-icon>
            </v-btn>
          <span>Periodo: 14/06 - 18/06/2021</span>
          <v-btn
            icon
            color="blue"
          >
            <v-icon>mdi-arrow-right-bold-circle-outline</v-icon>
          </v-btn>
        </v-responsive>

      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
            <v-col>
                <v-sheet
                  min-height="50vh"
                  rounded="lg" class="pa-5"
                >
                    <div id="chart">
                        <apexchart type="radar" height="400" :options="chartOptions" :series="series"></apexchart>
                    </div>
                </v-sheet>
            </v-col>
        </v-row>
        <v-row>
          <v-col cols="7">
            <v-sheet rounded="lg" min-height="70vh">
              <v-timeline class="pa-5">
                    <v-timeline-item
                      v-for="item in emotions"
                      :key="item.emotion"
                      color="white"
                    >
                      <template v-slot:icon>
                          <v-icon color="yellow darken-2" large>far fa-smile-beam</v-icon>
                      </template>
                      <div class="py-4">
                          <h2 :class="`headline font-weight-light mb-4 blue--text`">
                            {{item.emotion}}
                          </h2>
                          <div class="text-left" >
                            {{item.motivo}}
                          </div>
                        </div>
                    </v-timeline-item>
                  </v-timeline>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg" class="pa-5"
            >
                <!--
                <v-list >
                      <v-list-item
                        v-for="item in emotions"
                        :key="item.emotion"
                      >
                        <v-list-item-icon>
                          <v-icon color="yellow darken-2" x-large>far fa-smile-beam</v-icon>
                        </v-list-item-icon>

                        <v-list-item-content>
                          <v-list-item-title class="text-left" v-text="item.emotion"></v-list-item-title>
                        </v-list-item-content>

                        <v-list-item-avatar>
                          <v-progress-circular
                            :rotate="0"
                            :size="40"
                            :width="5"
                            :value="item.value"
                            color="teal"
                          >
                            {{ item.value }}
                          </v-progress-circular>
                        </v-list-item-avatar>
                      </v-list-item>
                </v-list>
                -->
                <v-list >
                    <v-list-item
                    v-for="item in morale.emotions"
                    :key="item.emotion"
                    >
                        <v-list-item-content>
                          <v-list-item-title class="text-left" v-text="item.emotion"></v-list-item-title>
                        </v-list-item-content>
                        <span class="black--text text--lighten-2 text-caption mr-2">
                            ({{ item.totalOnPeriod }})
                        </span>
                        <v-rating
                            v-model="item.totalOnPeriod * 5 / morale.maxOnPeriod"
                            background-color="yellow"
                            color="yellow accent-4"
                            dense
                            readonly
                            length="5"
                            half-increments
                            hover
                            size="32"
                        ></v-rating>
                    </v-list-item>
                </v-list>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

  import api from '../api/team'

  export default {
    name: 'MainLayout',
    mounted () {
        api.getMorale(
          '1',
          data => {
            this.morale = data;
            console.log(data)
          },
          error => {
            console.error(error)
          }
        );
    },
    data: () => ({
      links: [
        'Hacemos realidad tus ideas'
      ],
      morale: {
        maxOnPeriod : 1,
        emotions : [
            {
                emotion : 'FELIZ',
                totalOnPeriod : 1
            }

        ]
      },
      emotions: [
        {
            emotion: 'Feliz',
            value: 75,
            motivo: 'Me he sentido bien trabajando en equipo para ver de definir el arranque del registro de horas'
        },
        {
            emotion: 'Entusiasmado',
            value: 50,
            motivo: 'El nuevo entorno tecnológico promete, falta tener paciencia y esperar a que llegue'
        }
      ],
      series: [{
                  name: 'Series 1',
                  data: [8, 3, 6, 1, 1, 2,3,2],
                }
              ],
      chartOptions: {
        chart: {
            type: 'radar'
        },
        title: {
            text: 'Modelo Bifactorial Circumplejo de la Emoción'
        },
        plotOptions: {
              radar: {
                size: 150,
                polygons: {
                  strokeColors: '#e9e9e9',
                  fill: {
                    colors: ['#f8f8f8', '#fff']
                  }
                }
              }
        },
        stroke: {
            width: 3
        },
        dataLabels: {
            enabled: false
        },
        fill: {
            opacity: 0.1
        },
        theme: {
          mode: 'light',
          palette: 'palette1'
        },
        markers: {
            size: 0
        },
        xaxis: {
            categories: ['Alta activación', 'Afecto Positivo Alto', 'Placer', 'Afecto Negativo Bajo', 'Baja activación', 'Afecto Positivo Bajo','Displacer','Afecto Negativo Alto']
         }
      }
    }),
  }
</script>