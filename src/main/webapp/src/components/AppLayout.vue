<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
      dense
    >
      <v-container class="py-2 fill-height">
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

        <v-toolbar-title
          v-for="link in links"
          :key="link"
          class="text-uppercase"
        >
          {{ link }}
        </v-toolbar-title>

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
                    <div id="chart-container">
                        <apexchart ref="chart" type="radar" height="400" :options="chartOptions" :series="series"></apexchart>
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
        <v-row>
            <v-col><h2 id="observations" :class="`headline font-weight-black text-uppercase text-left font-weight-light mb-4 blue--text`">Observaciones</h2></v-col>
        </v-row>
        <v-row>
                <v-col cols="6">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                  </v-card>
                </v-col>
                <v-col cols="6">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                  </v-card>
                </v-col>
                <v-col cols="6">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                  </v-card>
                </v-col>
                <v-col cols="6">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                  </v-card>
                </v-col>
                <v-col cols="6">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                  </v-card>
                </v-col>
        </v-row>
        <v-row>
            <v-col><h2 id="action-plan" :class="`headline font-weight-black text-uppercase text-left font-weight-light mb-4 blue--text`">Plan de acción</h2></v-col>
        </v-row>
        <v-row>
                <v-col cols="12">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn icon>
                          <v-icon large>mdi-checkbox-multiple-marked-circle</v-icon>
                        </v-btn>
                      </v-card-actions>
                  </v-card>
                </v-col>
                <v-col cols="12">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <span class="v-fecha-accion text--subtitle-2 text--secondary font-weight-thin">[ 23/07/2021 ]</span>
                        <v-btn icon>
                          <v-icon color="green" large>mdi-checkbox-multiple-marked-circle</v-icon>
                        </v-btn>
                      </v-card-actions>
                  </v-card>
                </v-col>
                <v-col cols="12">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn icon>
                          <v-icon large>mdi-checkbox-multiple-marked-circle</v-icon>
                        </v-btn>
                      </v-card-actions>
                  </v-card>
                </v-col>
                <v-col cols="12">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                  <v-card-actions>
                                          <v-spacer></v-spacer>
                                          <v-btn icon>
                                            <v-icon large>mdi-checkbox-multiple-marked-circle</v-icon>
                                          </v-btn>
                                        </v-card-actions>
                  </v-card>
                </v-col>
                <v-col cols="12">
                  <v-card color="#FFFFFF">
                    <v-card-text class="black--text text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam venenatis neque nisl, fringilla sodales magna venenatis a. Duis a diam rhoncus, rutrum urna at, vestibulum felis. Quisque auctor efficitur leo ac aliquet. Sed tristique, nunc id suscipit pellentesque, libero orci tempus nisi, non viverra quam sapien vitae elit. Suspendisse potenti. In sit amet gravida enim. Donec commodo et ipsum sed bibendum. </v-card-text>
                    <v-card-actions>
                         <v-spacer></v-spacer>
                         <v-btn icon>
                           <v-icon large>mdi-checkbox-multiple-marked-circle</v-icon>
                         </v-btn>
                       </v-card-actions>
                  </v-card>
                </v-col>
        </v-row>
        <v-row>
            <v-col></v-col>
        </v-row>
        <v-row>
            <v-col></v-col>
        </v-row>
      </v-container>

    </v-main>
    <v-speed-dial
          bottom=true
          right=true
          direction="top"
          transition="slide-x-reverse-transition"
          fixed
          class="mb-12"
        >
          <template v-slot:activator>
            <v-btn
              v-model="fab"
              color="blue"
              dark
              fab
            >
                <v-icon>mdi-plus</v-icon>
            </v-btn>
          </template>
          <v-tooltip left>
              <template v-slot:activator="{ on, attrs }">
              <v-btn
                  fab
                  dark
                  small
                  v-bind="attrs"
                  @click="dialogemotion = true"
                  v-on="on"
              >
                    <v-icon>mdi-emoticon-happy-outline</v-icon>
              </v-btn>
              </template>
              <span>How you feel?</span>
          </v-tooltip>
          <v-tooltip left>
              <template v-slot:activator="{ on, attrs }">
              <v-btn
                  fab
                  dark
                  small
                  v-bind="attrs"
                  v-on="on"
                   @click="dialogobservation = true"
              >
                    <v-icon>mdi-message-bulleted</v-icon>
              </v-btn>
              </template>
              <span>New observation</span>
          </v-tooltip>
          <v-tooltip left>
                <template v-slot:activator="{ on, attrs }">
                <v-btn
                    fab
                    dark
                    small
                    v-bind="attrs"
                    v-on="on"
                    @click="dialogactionplan = true"
                >
                      <v-icon>mdi-checkbox-multiple-marked-circle</v-icon>
                </v-btn>
                </template>
                <span>New action</span>
          </v-tooltip>
    </v-speed-dial>
    <v-dialog
        v-model="dialogactionplan"
        persistent
        max-width="600px"
    >
        <v-card>
          <v-card-title>
            <span class="blue--text text-h5">New action</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col
                  cols="12"
                  sm="12"
                  md="12"
                >
                  <v-textarea
                        name="input-7-1"
                        required
                        hint="Action to plan"
                        persistent-hint
                        auto-grow
                        clearable
                        clear-icon="mdi-close-circle"
                        prepend-icon="mdi-checkbox-multiple-marked-circle"
                   ></v-textarea>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue darken-1"
              text
              @click="dialogactionplan = false"
            >
              Close
            </v-btn>
            <v-btn
              color="blue darken-1"
              text
              @click="dialogactionplan = false"
            >
              Add
            </v-btn>
          </v-card-actions>
    </v-card>
    </v-dialog>
    <v-dialog
        v-model="dialogobservation"
        persistent
        max-width="600px"
    >
        <v-card>
          <v-card-title>
            <span class="blue--text text-h5">New observation</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col
                  cols="12"
                  sm="12"
                  md="12"
                >
                  <v-textarea
                        name="input-7-1"
                        required
                        hint="Add an observation on this period"
                        persistent-hint
                        auto-grow
                        clearable
                        clear-icon="mdi-close-circle"
                        prepend-icon="mdi-message-bulleted"
                   ></v-textarea>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue darken-1"
              text
              @click="dialogobservation = false"
            >
              Close
            </v-btn>
            <v-btn
              color="blue darken-1"
              text
              @click="dialogobservation = false"
            >
              Add
            </v-btn>
          </v-card-actions>
    </v-card>
    </v-dialog>
    <v-dialog
        v-model="dialogemotion"
        persistent
        max-width="600px"
    >
        <v-card>
          <v-card-title>
            <span class="blue--text text-h5">How do you feel?</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col
                  cols="12"
                  sm="12"
                  md="12"
                >
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue darken-1"
              text
              @click="dialogemotion = false"
            >
              Close
            </v-btn>
            <v-btn
              color="blue darken-1"
              text
              @click="dialogemotion = false"
            >
              Add
            </v-btn>
          </v-card-actions>
    </v-card>
    </v-dialog>
    <v-bottom-navigation fixed>
        <v-tooltip top>
            <template v-slot:activator="{ on, attrs }">
            <v-btn href="#observations" v-bind="attrs" v-on="on">
                <v-badge content="5">
                    <v-icon>mdi-message-bulleted</v-icon>
                </v-badge>
            </v-btn>
            </template>
            <span>Go to observations</span>
        </v-tooltip>
        <v-tooltip top>
            <template v-slot:activator="{ on, attrs }">
            <v-btn href="#action-plan" v-bind="attrs" v-on="on">
                <v-badge content="1/5">
                    <v-icon>mdi-checkbox-multiple-marked-circle</v-icon>
                </v-badge>
            </v-btn>
            </template>
            <span>Go to action plan</span>
        </v-tooltip>
    </v-bottom-navigation>
  </v-app>

</template>

<style scoped>
  .v-fecha-accion {
    font-size: 0.9em;
    padding-right: 10px;
  }
</style>

<script>

  import api from '../api/team'

  export default {
    name: 'MainLayout',
    mounted () {
        api.getMorale(
          '1',
          data => {
            this.morale = data;

            this.series = [{name: 'Emotion Levels', data: data.emotionsByLevel}];
            var maxEmotions = data.maxLevelOnPeriod;
            console.log('Max emotions :'+ maxEmotions);
            var _options = {
                labels: data.levels,
                yaxis: {
                    max: maxEmotions,
                    forceNiceScale: true,
                    decimalsInFloat: 1,
                    labels: {
                         formatter: (value) => { return value.toFixed(0);  },
                    }
                }
            }
            this.$refs.chart.updateOptions(_options);

            console.log(data)
          },
          error => {
            console.error(error)
          }
        );
    },
    data: () => ({
      dialogactionplan: false,
      dialogobservation: false,
      dialogemotion: false,
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
            type: 'radar',
            toolbar: {
                show: false
            }
        },
        labels: ['Nivel 1', 'Nivel 2', 'Nivel 3', 'Nivel 4', 'Nivel 5', 'Nivel 6','Nivel 7','Nivel 8'],
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
        yaxis : {
            min : 0,
            forceNiceScale : true,
            decimalsInFloat: 1
        },
        stroke: {
            width: 3,
            curve: 'smooth'
        },
        dataLabels: {
            enabled: false
        },
        fill: {
            opacity: 0.1
        },
        markers: {
            size: 0
        }
      }
    }),
  }
</script>