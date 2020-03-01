export default {
  name: 'MessageListItem',
  template: `<div><li>{{ item.text }} - {{ item.createdAt | datetime }}
    <button @click="deleteClicked">X</button></li></div>`,
  props: {
    item: {
      type: Object,
      required: true
    }
  },
  methods: {
    deleteClicked () {
      this.$emit('delete');
    }
  }
}; 