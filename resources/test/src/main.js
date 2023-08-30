import { createApp } from "vue";
import { createRouter, createWebHistory } from "vue-router";
import App from "./App.vue";
import Login from "./pages/Login.vue";
import Person from "./pages/Person.vue";
import Register from "./pages/Register.vue";
import Ccategorization from "./pages/Categorization.vue";
import Article from "./pages/Article.vue";
import Home from "./pages/Home.vue";
import Header from "./pages/Header.vue";
import ExportToCodeErrorsDelete from "./pages/ExportToCodeErrorsDelete.vue";
import "./global.css";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/person",
    name: "Person",
    component: Person,
  },
  {
    path: "/register",
    name: "Register",
    component: Register,
  },
  
  {
    path: "/categorization",
    name: "Categorization",
    component: Ccategorization,
  },
  {
    path: "/article",
    name: "Article",
    component: Article,
  },
  {
    path: "/header",
    name: "Header",
    component: Header,
  },
  {
    path: "/export-to-code-errors-delete-me-anytime",
    name: "ExportToCodeErrorsDelete",
    component: ExportToCodeErrorsDelete,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((toRoute, fromRoute, next) => {
  const documentTitle =
    toRoute?.meta && toRoute?.meta?.title ? toRoute?.meta?.title : "test";
  window.document.title = documentTitle;
  if (toRoute?.meta?.description) {
    addMetaTag(toRoute?.meta?.description);
  }
  next();
});

const addMetaTag = (value) => {
  let element = document.querySelector(`meta[name='description']`);

  if (element) {
    element.setAttribute("content", value);
  } else {
    element = `<meta name="description" content="${value}" />`;
    document.head.insertAdjacentHTML("beforeend", element);
  }
};

createApp(App).use(router).mount("#app");

export default router;
