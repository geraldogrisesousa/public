class ObjectUtil {
  Convert = (object) => JSON.parse(JSON.stringify(object))
}
export default new ObjectUtil();
