import ActionPosition from './ActionPosition';

export default class TableSettings {
    id;

    type;

    data = [];

    hasActions = false;

    actionPosition = ActionPosition.Left;

    actions = [];

    headers = [];

    pagination = false;

    perPage = 5;

    checkbox = false;
}
