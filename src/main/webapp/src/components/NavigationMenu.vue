<template>
    <v-container>
    <v-navigation-drawer
        app
        class="text-left"
        temporary
        v-model="menuvisible"
    >
        <v-list-item>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                Focus Team
              </v-list-item-title>
              <v-list-item-subtitle>
                Team Morale
              </v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>

        <v-list nav dense>

          <v-list-item-group
            active-class="blue--text text--accent-4"
          >
            <v-list-item to="/">
              <v-list-item-icon>
                <v-icon>mdi-hospital-marker</v-icon>
              </v-list-item-icon>
              <v-list-item-title>Health</v-list-item-title>
            </v-list-item>


            <v-list-item to="/metrics">
              <v-list-item-icon>
                <v-icon>mdi-chart-bar</v-icon>
              </v-list-item-icon>
              <v-list-item-title>Metrics</v-list-item-title>
            </v-list-item>

          </v-list-item-group>

        </v-list>
    </v-navigation-drawer>
    <v-app-bar
          app
          color="white"
          flat
          dense
    >
      <v-app-bar-nav-icon @click.stop="menuvisible = !menuvisible"/>
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
            <v-toolbar-title class="text-uppercase">Hacemos realidad tus sueños</v-toolbar-title>

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
   </v-container>
</template>

<style scoped>
  .v-fecha-accion {
    font-size: 0.9em;
    padding-right: 10px;
  }
</style>

<script>
export default {
     data: () => ({
          menuvisible: false,
     })
}
</script>