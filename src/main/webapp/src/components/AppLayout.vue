<template>
  <v-app id="inspire">
   <NavigationMenu/>

   <v-main class="grey lighten-3">
        <router-view></router-view>
   </v-main>

  </v-app>
</template>



<script>
  import NavigationMenu from './NavigationMenu'

  export default {
    name: 'MainLayout',
    components: {NavigationMenu}
  }
</script>